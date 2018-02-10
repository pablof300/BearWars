package me.pabloestrada.beargametransition;

import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import me.pabloestrada.Util.MenuLoader;

public class Fade {

	private Rectangle fadeNode;
	private FadeType type;
	private StackPane container;

	public Fade(FadeType type, StackPane container) {
		this.fadeNode = new Rectangle();
		this.type = type;
		this.container = container;
		fadeNode.setWidth(container.getPrefWidth());
		fadeNode.setHeight(container.getPrefHeight());
		fadeNode.setFill(Color.BLACK);
		fadeNode.setOpacity(0);
		if (type == FadeType.IN)
			fadeNode.setOpacity(1);
		container.getChildren().add(fadeNode);
	}

	@SuppressWarnings("unchecked")
	public void load(final String nextSceneAddress) {
		double opacityValue = 1;
		if (type == FadeType.IN)
			opacityValue = 0;
		FadeTransition fadeTransition = new FadeTransition(new Duration(2000), fadeNode);
		fadeTransition.setToValue(opacityValue);
		fadeTransition.setCycleCount(1);
		fadeTransition.setAutoReverse(false);
		fadeTransition.play();
		fadeTransition.setOnFinished(new EventHandler() {

			public void handle(Event e) {
				container.getChildren().remove(fadeNode);
				if (nextSceneAddress != null)
					new MenuLoader(nextSceneAddress).load();
			}
		});
	}

	public void load(long delay, final String nextSceneAddress) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {

					public void run() {
						load(nextSceneAddress);

					}
				});

			}
		}, delay * 1000);
	}

}
