package me.pabloestrada.bearwarplayer;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Player {

	private ImageView playerNode;
	
	public Player(ImageView playerNode) {
		this.playerNode = playerNode;
	}

	/*public void moveTo(Position position, int time) {
		TranslateTransition tt = new TranslateTransition(Duration.millis(time * 1000), imageView);
	    tt.setByX(position.getX());
	    tt.setByY(position.getY());
	    tt.setCycleCount(1);
	    tt.setAutoReverse(true);
	    tt.play();
	}*/
	
}
