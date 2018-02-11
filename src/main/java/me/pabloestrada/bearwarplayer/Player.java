package me.pabloestrada.bearwarplayer;

import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import me.pabloestrada.beargamemovement.MovementDirection;
import me.pabloestrada.beargamemovement.Position;
import me.pabloestrada.beargamestats.PlayerStats;
import me.pabloestrada.bearwar.BearWarMain;

public class Player {

	private ImageView playerNode;
	private TranslateTransition movementTransition;

	private SpriteTexture loadedTexture;

	private final double DIRECTION_MAGNITUDE = 5;
	private int currentTexturePos = 0;

	private Text strengthNode;
	private Text stealthNode;
	private Text gathererNode;
	private Text defenseNode;

	private Text fishAmountNode;

	public Player(ImageView playerNode, Text... textNodes) {
		movementTransition = null;
		loadedTexture = SpriteTexture.REGULAR;

		this.playerNode = playerNode;
		this.strengthNode = textNodes[0];
		this.stealthNode = textNodes[1];
		this.gathererNode = textNodes[2];
		this.defenseNode = textNodes[3];
		this.fishAmountNode = textNodes[4];
	}

	public void incrementFish() {
		BearWarMain.getGameInfo().getPlayerStats().setMoney(BearWarMain.getGameInfo().getPlayerStats().getMoney() + 1);
		updateMoney();
	}

	public void updateMoney() {
		fishAmountNode.setText("" + (int) BearWarMain.getGameInfo().getPlayerStats().getMoney());
	}

	@SuppressWarnings("unchecked")
	public void moveTo(final MovementDirection direction) {
		updatePlayerTexture(direction);
		movementTransition = new TranslateTransition(Duration.millis(0.5), playerNode);
		movementTransition.setByX(DIRECTION_MAGNITUDE * direction.getX());
		movementTransition.setByY(DIRECTION_MAGNITUDE * direction.getY());
		movementTransition.setCycleCount(1);
		movementTransition.setAutoReverse(false);
		movementTransition.play();

		Bounds boundsInScene = playerNode.localToScene(playerNode.getBoundsInLocal());

		System.out.println("x: " + boundsInScene.getMaxX() + " and y: " + boundsInScene.getMaxY());
		System.out.println("x: " + boundsInScene.getMinX() + " and y:" + boundsInScene.getMinY());
	}

	public Position getPlayerMaxPosition() {
		Bounds boundsInScene = playerNode.localToScene(playerNode.getBoundsInLocal());
		return new Position(boundsInScene.getMaxX(), boundsInScene.getMaxY());
	}

	public Position getPlayerMinPosition() {
		Bounds boundsInScene = playerNode.localToScene(playerNode.getBoundsInLocal());
		return new Position(boundsInScene.getMinX(), boundsInScene.getMinY());
	}

	public double getPlayerWidth() {
		return playerNode.getImage().getWidth();
	}

	public double getPlayerHeight() {
		return playerNode.getImage().getHeight();
	}

	public void stopMoving() {
		if (isMoving()) {
			movementTransition.stop();
			movementTransition = null;
		}
	}

	private void updatePlayerTexture(MovementDirection direction) {
		Image bearImage = getBearImage(direction);
		double height = bearImage.getHeight();
		double width = bearImage.getWidth();
		playerNode.setImage(bearImage);
		playerNode.setFitHeight(height);
		playerNode.setFitWidth(width);
	}

	private Image getBearImage(MovementDirection direction) {
		currentTexturePos++;
		if (currentTexturePos >= 3)
			currentTexturePos = 0;
		return new Image(getClass().getResource("/" + "bear_" + loadedTexture.getTextureId() + "_"
				+ direction.getTexturePosition() + "_" + currentTexturePos + ".png").toExternalForm());
	}

	public boolean isMoving() {
		return movementTransition != null;
	}

}
