package me.pabloestrada.beargamelevels;

import java.util.HashMap;

public enum LevelStats {
	ONE(1, 3, 2, 0, 1, 10, 100), TWO(2, 5, 3, 0, 2, 15, 200), THREE(3, 7, 4, 0, 3, 20,300), FOUR(4, 9, 5, 0, 4, 30,500), FIVE(5, 12, 6, 0,
			5, 35,1000), SIX(6, 15, 8, 0, 6, 40,1500), SEVEN(7, 18, 9, 0, 7,
					45,3000), EIGHT(8, 21, 10, 0, 8, 50,10000), NINE(9, 25, 12, 0, 9, 55,20000), TEN(10, 30, 14, 0, 10, 60,30000);

	private int strength;
	private int stealth;
	private int gatherer;
	private int defense;
	private int hp;

	private int level;

	private int exp;
	
	private static HashMap<Integer, LevelStats> intToLevel;

	static {
		intToLevel = new HashMap<Integer, LevelStats>();
		for (LevelStats level : LevelStats.values()) {
			intToLevel.put(level.getLevel(), level);
		}
	}

	private LevelStats(int level, int strength, int stealth, int gatherer, int defense, int hp, int exp) {
		this.level = level;
		this.exp = exp;
		this.hp = hp;
		this.strength = strength;
		this.stealth = stealth;
		this.gatherer = gatherer;
		this.defense = defense;
	}

	public int getHp() {
		return hp;
	}

	public int getStrength() {
		return strength;
	}
	
	public int getExp() {
		return exp;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getGatherer() {
		return gatherer;
	}

	public void setGatherer(int gatherer) {
		this.gatherer = gatherer;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getLevel() {
		return level;
	}
	
	public static LevelStats getLevelStats(int level) {
		return intToLevel.get(level);
	}

}
