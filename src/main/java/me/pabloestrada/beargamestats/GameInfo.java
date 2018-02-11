package me.pabloestrada.beargamestats;

import me.pabloestrada.beargameshop.ShopType;

public class GameInfo {

	private static ShopType currentShop;
	private static PlayerStats stats;
	
	private static boolean isOnline;

	public ShopType getCurrentShop() {
		return currentShop;
	}

	public void setCurrentShop(ShopType currentShop) {
		GameInfo.currentShop = currentShop;
	}

	public PlayerStats getPlayerStats() {
		return stats;
	}
	
	public void setPlayerStats(PlayerStats playerStats) {
		stats = playerStats;
	}

	public static boolean isOnline() {
		return isOnline;
	}

	public static void setOnline(boolean isOnline) {
		GameInfo.isOnline = isOnline;
	}
	
}
