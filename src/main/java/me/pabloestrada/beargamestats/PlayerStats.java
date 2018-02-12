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

	private double hp;

	private int level;

	private Map<String, Object> farms;

	private Map<String, Object> items;

	private Map<String, Object> equippedItems;

	private int exp;

	public PlayerStats() {
		// Default constructor
	}

	public PlayerStats(String username, String password, int exp, double hp, int level, double money, int strength,
			int stealth, int gatherer, int defense, Map<String, Object> farms, Map<String, Object> items,
			Map<String, Object> equippedItems) {
		this.username = username;
		this.password = password;
		this.exp = exp;
		this.hp = hp;
		this.items = items;
		this.level = level;
		this.money = money;
		this.strength = strength;
		this.stealth = stealth;
		this.gatherer = gatherer;
		this.defense = defense;
		this.farms = farms;
		this.equippedItems = equippedItems;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public Map<String, Object> getEquippedItems() {
		return equippedItems;
	}

	public void setEquippedItems(Map<String, Object> equippedItems) {
		this.equippedItems = equippedItems;
	}

	public Map<String, Object> getItems() {
		return items;
	}

	public void setItems(Map<String, Object> items) {
		this.items = items;
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
		return "Player: " + username + " of password: " + password + " has money $" + money + " a level of " + level
				+ " a str of" + strength + " a stealth of " + stealth + " a gather of " + gatherer
				+ " and a defense of " + defense + " hp: " + hp;
	}

	public void updateStats(int strength, int stealth, int gatherer, int defense) {
		this.strength += strength;
		this.stealth += stealth;
		this.gatherer += gatherer;
		this.defense += defense;
	}

}
