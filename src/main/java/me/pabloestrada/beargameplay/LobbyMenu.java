package me.pabloestrada.beargameplay;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import me.pabloestrada.beargamemovement.KeyListener;
import me.pabloestrada.bearwar.BearWarMain;
import me.pabloestrada.bearwarplayer.Player;

public class LobbyMenu {

	@FXML
	private ImageView playerNode;

	private KeyListener keyListener;
	private Player player;

	@FXML
	private void initialize() {
	 player = new Player(playerNode);
		launchKeyListener(player);
	}

	private void launchKeyListener(final Player player) {
		Platform.runLater(new Runnable() {

			public void run() {
				BearWarMain.getMainStage().getScene().setOnKeyPressed(new KeyListener(player));
			}
		});
	}
}
