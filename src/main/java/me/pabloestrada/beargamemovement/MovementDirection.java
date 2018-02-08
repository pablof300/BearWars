package me.pabloestrada.beargamemovement;

import java.util.HashMap;
import java.util.Set;

public enum MovementDirection {

	UP("UP", "W", 0, -1), RIGHT("RIGHT", "D", 1, 0), DOWN("DOWN", "S", 0, 1), LEFT("LEFT", "A", -1, 0), NONE("", "", 0,
			0);

	private String mainKey;
	private String alternativeKey;

	private int x;
	private int y;

	private static HashMap<String, MovementDirection> nameMap;

	static {
		nameMap = new HashMap<String, MovementDirection>();
		for (MovementDirection direction : MovementDirection.values()) {
			nameMap.put(direction.getMainKey(), direction);
			nameMap.put(direction.getAlternativeKey(), direction);
		}
	}

	private MovementDirection(String mainKey, String alternativeKey, int x, int y) {
		this.mainKey = mainKey;
		this.x = x;
		this.y = y;
		this.alternativeKey = alternativeKey;
	}

	public static MovementDirection getPlayerDirection(String rawDirection) {
		return nameMap.get(rawDirection);
	}

	public static Set<String> getValidKeys() {
		return nameMap.keySet();
	}

	public String getMainKey() {
		return mainKey;
	}

	public String getAlternativeKey() {
		return alternativeKey;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
