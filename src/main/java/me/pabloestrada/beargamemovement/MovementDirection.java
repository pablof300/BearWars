package me.pabloestrada.beargamemovement;

import java.util.HashMap;

public enum MovementDirection {

	UP("UP", "W"), RIGHT("RIGHT", "D"), DOWN("DOWN", "S"), LEFT("LEFT", "A");

	private String mainKey;
	private String alternativeKey;

	private static HashMap<String, MovementDirection> nameMap;
	
	static {
		nameMap = new HashMap<String, MovementDirection>();
		for(MovementDirection direction : MovementDirection.values()) {
			nameMap.put(direction.getMainKey(), direction);
			nameMap.put(direction.getAlternativeKey(), direction);
		}
	}
	
	private MovementDirection(String mainKey, String alternativeKey) {
		this.mainKey = mainKey;
		this.alternativeKey = alternativeKey;
	}
	
	public String getMainKey() {
		return mainKey;
	}
	
	public String getAlternativeKey() {
		return alternativeKey;
	}

}
