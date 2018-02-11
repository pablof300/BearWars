package me.pabloestrada.beargamemovement;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.beargameplay.LobbyMenu;
import me.pabloestrada.bearwarplayer.Player;

public class Movement {

	private Timer timer;
	private MovementDirection playerDirection;
	private Player player;
	
	private List<Region> blockedRegions;
	private List<Region> regionsOfInterest;
	private LobbyMenu lobby;

	public Movement(Player player, List<Region> blockedRegions, List<Region> regionsOfInterest,LobbyMenu lobby) {
		this.blockedRegions = blockedRegions;
		this.player = player;
		this.lobby = lobby;
		this.regionsOfInterest = regionsOfInterest;
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
	
	private RoomType getRegionOfInterest(MovementDirection direction) {
		for (Region region : regionsOfInterest) {
			if (region.isInRegion(player, direction))
				return region.getRoomType();
		}
		return RoomType.LOBBY;
	}
	
	private boolean canMove(MovementDirection direction) {
		for (Region region : blockedRegions) {
			if (region.isInRegion(player, direction))
				return false;
		}
		return true;
	}
	
	private void loadNewRoom(RoomType type) {
		lobby.stopFarms();
		new MenuLoader(type.getFXMLAddress()).load();
	}

	public void setPlayerDirection(MovementDirection direction) {
		RoomType type = getRegionOfInterest(direction);
		if(type != RoomType.LOBBY)
			loadNewRoom(type);
		if (!canMove(direction))
			return;
		updatePlayerDirection(direction);
	}

}
