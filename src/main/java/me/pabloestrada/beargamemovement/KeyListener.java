package me.pabloestrada.beargamemovement;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import me.pabloestrada.bearwarplayer.Player;

public class KeyListener implements EventHandler<KeyEvent> {

	private Player player;

	public KeyListener(Player player) {
		this.player = player;
	}

	public void handle(KeyEvent event) {
		System.out.println(event.getCharacter());
		System.out.println(event.getCode());

	}
}
