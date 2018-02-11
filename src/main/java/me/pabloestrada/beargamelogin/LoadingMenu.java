package me.pabloestrada.beargamelogin;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import me.pabloestrada.beargamemusic.Music;
import me.pabloestrada.beargamemusic.MusicType;
import me.pabloestrada.beargametransition.Fade;
import me.pabloestrada.beargametransition.FadeType;

public class LoadingMenu {

	@FXML
	private StackPane pane;
	
	private Music music;
	
	@FXML
	private void initialize() {
		new Fade(FadeType.IN, pane).load(null);
		new Fade(FadeType.OUT, pane).load(3, "loginscreen");
		music = new Music(MusicType.LOADING);
		music.play();
	}
	
}
