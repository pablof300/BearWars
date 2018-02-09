package me.pabloestrada.beargamemovement;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.pabloestrada.bearwarplayer.Player;

public class Movement {

	private Timer timer;
	private MovementDirection playerDirection;
	private Player player;
	private List<Region> blockedRegions;

	public Movement(Player player, List<Region> blockedRegions) {
		this.blockedRegions = blockedRegions;
		this.player = player;
		playerDirection = MovementDirection.NONE;
		timer = new Timer();
	}

	private void updatePlayerDirection(MovementDirection direction) {
		player.stopMoving();
		playerDirection = direction;
		player.moveTo(direction);
	}

	/*private void launchMovementEngine() {
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				
			}
		}, 0, 500);
	}*/

	private boolean canMove(MovementDirection direction) {
		for (Region region : blockedRegions) {
			if (region.isInRegion(player, direction))
				return false;
		}
		return true;
	}

	public void setPlayerDirection(MovementDirection direction) {
		if (!canMove(direction))
			return;
		updatePlayerDirection(direction);
	}

}
