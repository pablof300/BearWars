package me.pabloestrada.beargamemovement;

import java.util.Timer;
import java.util.TimerTask;

import me.pabloestrada.bearwarplayer.Player;

public class Movement {

	private Timer timer;
	private MovementDirection playerDirection;
	private Player player;

	public Movement(Player player) {
		this.player = player;
		playerDirection = MovementDirection.NONE;
		timer = new Timer();
	}

	private void updatePlayerDirection(MovementDirection direction) {
		player.stopMoving();
		playerDirection = direction;
		player.moveTo(direction);
	}

	private void launchMovementEngine() {
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				//updatePlayerDirection();

			}
		}, 0, 500);
	}
	
	public void setPlayerDirection(MovementDirection direction) {
		//this.playerDirection = direction;
		updatePlayerDirection(direction);
	}

}
