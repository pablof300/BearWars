package me.pabloestrada.beargamelogin;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.beargamemusic.Music;
import me.pabloestrada.beargamemusic.MusicType;
import me.pabloestrada.beargamestats.GameInfo;
import me.pabloestrada.beargametransition.Fade;
import me.pabloestrada.beargametransition.FadeType;

public class LoginScreen {

	@FXML
	private StackPane pane;

	public static Music music;

	@FXML
	private void initialize() {
		if (music == null) {
			music = new Music(MusicType.LOGIN);
			music.playAndRepeat();
		}
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
