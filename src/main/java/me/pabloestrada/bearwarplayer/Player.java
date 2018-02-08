package me.pabloestrada.bearwarplayer;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import me.pabloestrada.beargamemovement.MovementDirection;

public class Player {

	private ImageView playerNode;
	private TranslateTransition movementTransition;

	private final double DIRECTION_MAGNITUDE = 5;

	public Player(ImageView playerNode) {
		movementTransition = null;
		this.playerNode = playerNode;
	}

	@SuppressWarnings("unchecked")
	public void moveTo(final MovementDirection direction) {
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

	public boolean isMoving() {
		return movementTransition != null;
	}

}
