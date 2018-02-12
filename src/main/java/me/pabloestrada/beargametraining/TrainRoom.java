package me.pabloestrada.beargametraining;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.beargameplay.LobbyMenu;
import me.pabloestrada.bearwar.BearWarMain;

public class TrainRoom {

	@FXML
	private Text lvl_1;
	@FXML
	private Text lvl_2;
	@FXML
	private Text lvl_3;
	@FXML
	private Text lvl_4;
	@FXML
	private Text lvl_5;
	@FXML
	private Text lvl_6;
	@FXML
	private Text lvl_7;
	@FXML
	private Text lvl_8;
	@FXML
	private Text lvl_9;
	@FXML
	private Text lvl_10;
	
	private HashMap<Text, Integer> nodeToLevel;
	
	@FXML
	private void initialize() {
		Text[] nodes = {lvl_1,lvl_2,lvl_3,lvl_4,lvl_5,lvl_6,lvl_7,lvl_8,lvl_9,lvl_10};
		nodeToLevel = new HashMap<Text, Integer>();
		for(int level = 0; level < nodes.length; level++) 
			nodeToLevel.put(nodes[level], level + 1);
	}
	
	@FXML
	private void startTraining(MouseEvent e) {
		int trainingLevel = nodeToLevel.get(e.getSource());
		BearWarMain.getGameInfo().setTrainingLevel(trainingLevel);
		BearWarMain.getGameInfo().setTraining(true);
		
		new MenuLoader("battle_menu").load();
	}
	
}
