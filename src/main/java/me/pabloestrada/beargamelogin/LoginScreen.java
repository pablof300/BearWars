package me.pabloestrada.beargamelogin;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
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
		
	}
	
	@FXML
	private void register() {
		
	}
	
	@FXML
	private void singlePlayer() {
		
	}
	
}
