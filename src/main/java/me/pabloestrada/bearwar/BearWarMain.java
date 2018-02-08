package me.pabloestrada.bearwar;

import javafx.application.Application;
import javafx.stage.Stage;
import me.pabloestrada.Util.MenuLoader;

public class BearWarMain extends Application {
	private static Stage mainStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		mainStage = stage;
		new MenuLoader("lobby").load();
		mainStage.setResizable(false);
		mainStage.show();
		mainStage.setTitle("Bear War");
	}

	public static Stage getMainStage() {
		return mainStage;
	}
}
