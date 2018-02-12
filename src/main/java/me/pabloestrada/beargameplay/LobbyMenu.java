package me.pabloestrada.beargameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import me.pabloestrada.beargamedatabase.DatabaseUtil;
import me.pabloestrada.beargamefarms.Farm;
import me.pabloestrada.beargamelevels.LevelStats;
import me.pabloestrada.beargamemovement.KeyListener;
import me.pabloestrada.beargamemovement.Movement;
import me.pabloestrada.beargamemovement.Position;
import me.pabloestrada.beargamemovement.Region;
import me.pabloestrada.beargamemovement.RoomType;
import me.pabloestrada.beargamemusic.Music;
import me.pabloestrada.beargamemusic.MusicType;
import me.pabloestrada.beargamestats.GameInfo;
import me.pabloestrada.beargamestats.PlayerStats;
import me.pabloestrada.bearwar.BearWarMain;
import me.pabloestrada.bearwarplayer.Player;

public class LobbyMenu {

	@FXML
	private ImageView playerNode;

	@FXML
	private StackPane pane;

	@FXML
	private ImageView farm_0;
	@FXML
	private ImageView farm_1;
	@FXML
	private ImageView farm_2;
	@FXML
	private ImageView farm_3;
	@FXML
	private ImageView farm_4;

	@FXML
	private Text strengthNode;
	@FXML
	private Text stealthNode;
	@FXML
	private Text gathererNode;
	@FXML
	private Text defenseNode;
	@FXML
	private Text fishAmountNode;

	@FXML
	private Text usernameNode;
	@FXML
	private Text levelNode;

	@FXML
	private Text status;

	private Farm[] farms;
	private HashMap<ImageView, Farm> nodeToFarm;

	private Player player;
	private Movement movementEngine;

	private Timer updater;

	@FXML
	private ProgressBar hp;
	@FXML
	private Text hp_text;

	@FXML
	private Text exp;

	public void updateHp() {
		double percentage = BearWarMain.getGameInfo().getPlayerStats().getHp()
				/ (double) LevelStats.getLevelStats(BearWarMain.getGameInfo().getPlayerStats().getLevel()).getHp();
		Timeline timeline = new Timeline();

		KeyValue keyValue = new KeyValue(hp.progressProperty(), percentage);
		KeyFrame keyFrame = new KeyFrame(new Duration(1000), keyValue);
		timeline.getKeyFrames().add(keyFrame);

		timeline.play();

		hp_text.setText(" HP: (" + (int) BearWarMain.getGameInfo().getPlayerStats().getHp() + "/"
				+ LevelStats.getLevelStats(BearWarMain.getGameInfo().getPlayerStats().getLevel()).getHp() + ")");
	}

	private void updateExp() {
		if (BearWarMain.getGameInfo().getPlayerStats().getExp() >= LevelStats
				.getLevelStats(BearWarMain.getGameInfo().getPlayerStats().getLevel()).getExp()) {
			LevelStats prev = LevelStats.getLevelStats(BearWarMain.getGameInfo().getPlayerStats().getLevel());
			LevelStats next = LevelStats.getLevelStats(BearWarMain.getGameInfo().getPlayerStats().getLevel() + 1);
			BearWarMain.getGameInfo().getPlayerStats().setExp(0);
			BearWarMain.getGameInfo().getPlayerStats()
					.setLevel(BearWarMain.getGameInfo().getPlayerStats().getLevel() + 1);

			BearWarMain.getGameInfo().getPlayerStats()
					.setStrength(BearWarMain.getGameInfo().getPlayerStats().getStrength()
							+ (next.getStrength() - prev.getStrength()));
			
			BearWarMain.getGameInfo().getPlayerStats()
			.setStrength(BearWarMain.getGameInfo().getPlayerStats().getStealth()
					+ (next.getStealth() - prev.getStealth()));
			
			BearWarMain.getGameInfo().getPlayerStats()
			.setStrength(BearWarMain.getGameInfo().getPlayerStats().getDefense()
					+ (next.getDefense() - prev.getDefense()));

		}
		exp.setText(BearWarMain.getGameInfo().getPlayerStats().getExp() + "/"
				+ LevelStats.getLevelStats(BearWarMain.getGameInfo().getPlayerStats().getLevel()).getExp());
		levelNode.setText("Lvl " + BearWarMain.getGameInfo().getPlayerStats().getLevel());
		DatabaseUtil.updateUserdata();
	}

	@FXML
	private void initialize() {
		updateExp();
		updateHp();
		BearWarMain.getGameInfo().getMusic().setType(MusicType.LOBBY);

		Font.loadFont(getClass().getResourceAsStream("/LCD_Solid.ttf"), 44);

		player = new Player(playerNode,
				new Text[] { strengthNode, stealthNode, gathererNode, defenseNode, fishAmountNode });
		movementEngine = new Movement(player, getRegions(), getRegionsOfInterest(), this);
		System.out.println(BearWarMain.getGameInfo().getPlayerStats());

		fishAmountNode.setText("" + (int) BearWarMain.getGameInfo().getPlayerStats().getMoney());
		usernameNode.setText(BearWarMain.getGameInfo().getPlayerStats().getUsername());
		levelNode.setText("Lvl " + BearWarMain.getGameInfo().getPlayerStats().getLevel());
		strengthNode.setText("" + BearWarMain.getGameInfo().getPlayerStats().getStrength());
		stealthNode.setText("" + BearWarMain.getGameInfo().getPlayerStats().getStealth());
		gathererNode.setText("" + BearWarMain.getGameInfo().getPlayerStats().getGatherer());
		defenseNode.setText("" + BearWarMain.getGameInfo().getPlayerStats().getDefense());

		if (GameInfo.isOnline()) {
			updater = new Timer();
			startUpdating();
		}

		launchKeyListener();
		loadFarms();
	}

	public void stopFarms() {
		updater.cancel();
		for (Farm farm : farms) {
			farm.stopFarming();
		}
	}

	private void startUpdating() {
		updater.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {

					public void run() {
						DatabaseUtil.updateUserdata();

					}
				});

			}
		}, 20 * 1000, 20 * 1000);

	}

	@FXML
	private void farm(MouseEvent event) {
		Farm clickedFarm = nodeToFarm.get(event.getSource());
		clickedFarm.farmFish();
	}

	private void launchKeyListener() {
		Platform.runLater(new Runnable() {

			public void run() {
				BearWarMain.getMainStage().getScene().setOnKeyPressed(new KeyListener(movementEngine));
			}
		});
	}

	private void loadFarms() {
		farms = new Farm[5];
		nodeToFarm = new HashMap<ImageView, Farm>();
		ImageView[] farmNodes = { farm_0, farm_1, farm_2, farm_3, farm_4 };
		long[] rates = { 0, 750, 500, 250, 250 };
		for (int i = 0; i < farmNodes.length; i++) {
			if (i == 0)
				farms[i] = new Farm(i, pane, player, status);
			else
				farms[i] = new Farm(rates[i], i, pane, player, status);
			nodeToFarm.put(farmNodes[i], farms[i]);
		}

		PlayerStats stats = BearWarMain.getGameInfo().getPlayerStats();
		for (String farmId : stats.getFarms().keySet()) {
			if ((Boolean) stats.getFarms().get(farmId))
				farms[Integer.parseInt(farmId.substring(5))].unlockFarm();
		}
	}

	private List<Region> getRegionsOfInterest() {
		ArrayList<Region> regions = new ArrayList<Region>();
		double[][] topPosition = { { 312, 158 }, { 220, 0 }, { 325, 0 } };
		double[][] bottomPosition = { { 350, 200 }, { 270, 51 }, { 375, 51 } };
		RoomType[] regionTypes = { RoomType.HEALING, RoomType.TRAINING_ROOM, RoomType.SHOP_ROOM };
		for (int r = 0; r < topPosition.length; r++) {
			regions.add(new Region(new Position(topPosition[r][0], topPosition[r][1]),
					new Position(bottomPosition[r][0], bottomPosition[r][1]), regionTypes[r]));
		}
		return regions;
	}

	private List<Region> getRegions() {
		ArrayList<Region> regions = new ArrayList<Region>();
		double[][] topPosition = { { 0, 0 }, { 0, 0 }, { 110, 141 }, { 414, 0 } };
		double[][] bottomPosition = { { 35, 600 }, { 500, 51 }, { 185, 213 }, { 520, 311 } };
		for (int r = 0; r < topPosition.length; r++) {
			regions.add(new Region(new Position(topPosition[r][0], topPosition[r][1]),
					new Position(bottomPosition[r][0], bottomPosition[r][1])));
		}
		return regions;
	}

	public Text getStatus() {
		return status;
	}
}
