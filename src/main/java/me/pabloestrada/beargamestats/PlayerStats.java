package me.pabloestrada.beargamestats;

public class PlayerStats {

	private String username;
	private String password;
	
	private double money;
	
	public PlayerStats() {
		// Default constructor
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
	
	
}
