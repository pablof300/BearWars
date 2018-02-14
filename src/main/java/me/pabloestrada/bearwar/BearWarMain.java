package me.pabloestrada.bearwar;

import javafx.application.Application;
import javafx.stage.Stage;
import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.beargameconfiguration.ConfigurationFile;
import me.pabloestrada.beargamedatabase.DatabaseUtil;
import me.pabloestrada.beargamestats.GameInfo;

public class BearWarMain extends Application {
	private static Stage mainStage;
	private static GameInfo gameInfo;
	private static ConfigurationFile config;
	
	public static void main(String[] args) {
		launch(args);
	
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		gameInfo = new GameInfo();
		config = new ConfigurationFile();
		
		DatabaseUtil.authenticateDatabase();
		mainStage = stage;
		new MenuLoader("loadingscreen").load();
		mainStage.setResizable(false);
		mainStage.show();
		mainStage.setTitle("Bear War");
	}

	public static Stage getMainStage() {
		return mainStage;
	}
	
	public static GameInfo getGameInfo() {
		return gameInfo;
	}
}
