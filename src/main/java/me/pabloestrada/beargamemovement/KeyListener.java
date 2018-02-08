package me.pabloestrada.beargamemovement;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyListener implements EventHandler<KeyEvent> {

	private Movement movementEngine;

	public KeyListener(Movement movementEngine) {
		this.movementEngine = movementEngine;
	}

	public void handle(KeyEvent event) {
		if (!isValidKey(event.getCharacter()))
			return;
		movementEngine.setPlayerDirection(MovementDirection.getPlayerDirection(event.getCharacter()));
	}

	public boolean isValidKey(String key) {
		for (String validKey : MovementDirection.getValidKeys()) {
			if (validKey.equals(key))
				return true;
		}
		return false;
	}
}
