package me.pabloestrada.beargameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import me.pabloestrada.beargamefarms.Farm;
import me.pabloestrada.beargamemovement.KeyListener;
import me.pabloestrada.beargamemovement.Movement;
import me.pabloestrada.beargamemovement.Position;
import me.pabloestrada.beargamemovement.Region;
import me.pabloestrada.beargamemovement.RoomType;
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
	private Text status;

	private Farm[] farms;
	private HashMap<ImageView, Farm> nodeToFarm;

	private Player player;
	private Movement movementEngine;

	@FXML
	private void initialize() {

		Font.loadFont(getClass().getResourceAsStream("/LCD_Solid.ttf"), 44);

		player = new Player(playerNode,
				new Text[] { strengthNode, stealthNode, gathererNode, defenseNode, fishAmountNode });
		movementEngine = new Movement(player, getRegions(), getRegionsOfInterest());
		launchKeyListener();
		loadFarms();
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
	}

	private List<Region> getRegionsOfInterest() {
		ArrayList<Region> regions = new ArrayList<Region>();
		double[][] topPosition = { { 100, 0 }, { 220, 0 }, { 325, 0 } };
		double[][] bottomPosition = { { 145, 51 }, { 270, 51 }, { 375, 51 } };
		RoomType[] regionTypes = {RoomType.MULTIPLAYER_ROOM, RoomType.TRAINING_ROOM, RoomType.SHOP_ROOM};
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
}
