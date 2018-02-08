package me.pabloestrada.bearwarplayer;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import me.pabloestrada.beargamemovement.MovementDirection;

public class Player {

	private ImageView playerNode;
	private TranslateTransition movementTransition;

	private SpriteTexture loadedTexture;

	private final double DIRECTION_MAGNITUDE = 5;
	private int currentTexturePos = 0;

	public Player(ImageView playerNode) {
		movementTransition = null;
		loadedTexture = SpriteTexture.REGULAR;
		this.playerNode = playerNode;
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
