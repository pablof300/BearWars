package me.pabloestrada.beargamefarms;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import me.pabloestrada.beargamemovement.Position;
import me.pabloestrada.bearwarplayer.Player;

public class Farm {

	private static HashMap<Integer, Position> positionMap;
	private static HashMap<Integer, Integer> pricesMap;

	static {
		positionMap = new HashMap<Integer, Position>();
		pricesMap = new HashMap<Integer, Integer>();

		// Convert to enum!
		Position[] positions = { new Position(100, -290), new Position(190, 86), new Position(190, 270),
				new Position(0, 270), new Position(0, 86) };
		int[] prices = { 0, 1, 1, 1, 1 };

		for (int i = 0; i < positions.length; i++) {
			positionMap.put(i, positions[i]);
			pricesMap.put(i, prices[i]);
		}
	}

	private Timer timer;
	private long automaticRate;
	private int price;
	private Position awardFishPosition;
	private StackPane pane;

	private Text status;

	private Player player;

	private boolean isLocked;

	public Farm(int id, StackPane pane, Player player, Text status) {
		this.pane = pane;
		this.player = player;
		this.status = status;
		automaticRate = 0;
		price = 0;
		awardFishPosition = positionMap.get(id);
		isLocked = false;
	}

	public Farm(long automaticRate, int id, StackPane pane, Player player, Text status) {
		this.pane = pane;
		this.player = player;
		this.status = status;
		this.automaticRate = automaticRate;
		this.isLocked = true;
		price = pricesMap.get(id);
		awardFishPosition = positionMap.get(id);
		if (!isLocked)
			startFarming();
	}

	public void startFarming() {
		timer = new Timer();
		

			
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						Platform.runLater(new Runnable() {

							public void run() {
								farmFish();
								
							}});

					}
				}, 0, automaticRate);	
			
	}

	private Image getFishImage() {
		return new Image(getClass().getResource("/" + "fish_reward.png").toExternalForm());
	}

	private void attemptUnlockFarm() {
		if (player.getStats().getMoney() < price) {
			status.setText("You need $" + (int)(price - player.getStats().getMoney()) + " to purchase this farm!");
			return;
		}
		isLocked = false;
		startFarming();
		status.setText("You have purchased a farm for $" + price);
		player.getStats().setMoney(player.getStats().getMoney() - price);
		player.updateMoney();
	}

	@SuppressWarnings("unchecked")
	public void farmFish() {
		if (isLocked) {
			attemptUnlockFarm();
			return;
		}

		player.incrementFish();

		Image fishImage = getFishImage();
		final ImageView fishNode = new ImageView(fishImage);
		pane.getChildren().add(fishNode);

		fishNode.setFitHeight(fishImage.getHeight());
		fishNode.setFitWidth(fishImage.getWidth());

		pane.setMargin(fishNode, new Insets(awardFishPosition.getX(), awardFishPosition.getY(), 0, 0));

		FadeTransition transition = new FadeTransition(new Duration(500), fishNode);
		transition.setToValue(0);
		transition.setCycleCount(1);
		transition.setAutoReverse(false);
		transition.play();

		transition.setOnFinished(new EventHandler() {

			public void handle(Event arg0) {

				pane.getChildren().remove(fishNode);
			}
		});
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

}



