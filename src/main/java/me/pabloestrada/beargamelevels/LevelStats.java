package me.pabloestrada.beargamelevels;

public enum LevelStats {
	ONE(1,1,0,1),TWO(1,1,0,1),THREE(1,1,0,1),FOUR(1,1,0,1),FIVE(1,1,0,1),SIX(1,1,0,1),SEVEN(1,1,0,1),EIGHT(1,1,0,1),NINE(1,1,0,1),TEN(1,1,0,1); 
	
	private int strength;
	private int stealth;
	private int gatherer;
	private int defense;
	
	
	private LevelStats(int strength, int stealth, int gatherer, int defense) {
		this.strength = strength;
		this.stealth = stealth;
		this.gatherer = gatherer;
		this.defense = defense;
	}


	public int getStrength() {
		return strength;
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

	
}
