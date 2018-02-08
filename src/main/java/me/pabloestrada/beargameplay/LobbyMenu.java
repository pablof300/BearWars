package me.pabloestrada.beargameplay;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import me.pabloestrada.beargamemovement.KeyListener;
import me.pabloestrada.beargamemovement.Movement;
import me.pabloestrada.bearwar.BearWarMain;
import me.pabloestrada.bearwarplayer.Player;

public class LobbyMenu {

	@FXML
	private ImageView playerNode;

	private KeyListener keyListener;
	private Player player;
	private Movement movementEngine;

	@FXML
	private void initialize() {
		movementEngine = new Movement(player);
		player = new Player(playerNode);
		launchKeyListener();
	}

	private void launchKeyListener() {
		Platform.runLater(new Runnable() {

			public void run() {
				BearWarMain.getMainStage().getScene().setOnKeyPressed(new KeyListener(movementEngine));
			}
		});
	}
}
