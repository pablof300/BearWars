package me.pabloestrada.beargamelogin;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.beargamestats.GameInfo;
import me.pabloestrada.beargametransition.Fade;
import me.pabloestrada.beargametransition.FadeType;

public class LoginScreen {
	
	@FXML
	private StackPane pane;

	@FXML
	private void initialize() {
		new Fade(FadeType.IN, pane).load(null);
	}
	
	@FXML
	private void login() {
		new MenuLoader("loginmenu").load();
	}
	
	@FXML
	private void register() {
		new MenuLoader("registermenu").load();
	}
	
	@FXML
	private void singlePlayer() {
		GameInfo.setOnline(false);
	}
	
}
