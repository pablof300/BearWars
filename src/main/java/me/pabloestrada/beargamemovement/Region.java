package me.pabloestrada.beargamemovement;

import com.sun.javafx.scene.traversal.Direction;

import me.pabloestrada.bearwarplayer.Player;

public class Region {

	private Position topLeft;
	private Position bottomRight;

	public Region(Position topLeft, Position bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}

	public boolean isInRegion(Position pos) {
		return (pos.getX() <= bottomRight.getX() && pos.getX() >= topLeft.getX())
				&& (pos.getY() >= topLeft.getY() && pos.getY() <= bottomRight.getY());
	}

	public boolean isInRegion(Player player, MovementDirection direction) {
		System.out.println("Original positons are " + player.getPlayerMaxPosition() + " and " + player.getPlayerMinPosition());
		Position updatedMaxPosition = new Position(player.getPlayerMaxPosition().getX() + 5 * direction.getX(),
				player.getPlayerMaxPosition().getY() + 5 * direction.getY());
		Position updatedMinPosition = new Position(player.getPlayerMinPosition().getX() + 5 * direction.getX(),
				player.getPlayerMinPosition().getY() + 5 * direction.getY());
		
		System.out.println("\nChecking for ");
		System.out.println(updatedMaxPosition);
		System.out.println(updatedMinPosition);
		System.out.println("For the following region ");
		System.out.println(this+ "\n");
		
		return isInRegion(updatedMaxPosition) || isInRegion(updatedMinPosition);
	}
	
	public String toString() {
		return "Spans from top left " + topLeft + " to bottomRight" + bottomRight;
	}
}
