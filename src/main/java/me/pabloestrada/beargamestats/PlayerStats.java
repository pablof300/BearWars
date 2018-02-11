package me.pabloestrada.beargamestats;

import java.util.HashMap;
import java.util.Map;

public class PlayerStats {

	private String username;
	private String password;
	public double money;

	private int strength;
	private int stealth;
	private int gatherer;
	private int defense;

	private int level;

	private Map<String, Object> farms;
	
	public PlayerStats() {
		// Default constructor
	}

	public PlayerStats(String username, String password, int level, double money, int strength, int stealth,
			int gatherer, int defense, Map<String, Object> farms) {
		this.username = username;
		this.password = password;
		this.level = level;
		this.money = money;
		this.strength = strength;
		this.stealth = stealth;
		this.gatherer = gatherer;
		this.defense = defense;
		this.farms = farms;
	}

	public Map<String, Object> getFarms() {
		return farms;
	}

	public void setFarms(Map<String, Object> farms) {
		this.farms = farms;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Player: " + username + " of password: " + password + " has money $" + money ;
	}

}
