package me.pabloestrada.beargamestats;

import me.pabloestrada.beargamemusic.Music;
import me.pabloestrada.beargameshop.ShopType;

public class GameInfo {

	private static ShopType currentShop;
	private static PlayerStats stats;
	
	private static boolean isOnline;
	private static int trainingLevel;
	
	private static boolean isTraining;
	
	private static Music music;
	
	private static String APIkey;
	private static String firebaseAddress;

	static {
		music = new Music();
	}
	
	public ShopType getCurrentShop() {
		return currentShop;
	}

	public void setCurrentShop(ShopType currentShop) {
		GameInfo.currentShop = currentShop;
	}

	public PlayerStats getPlayerStats() {
		return stats;
	}
	
	public static int getTrainingLevel() {
		return trainingLevel;
	}

	public static void setTrainingLevel(int trainingLevel) {
		GameInfo.trainingLevel = trainingLevel;
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
	
	public static boolean isTraining() {
		return isTraining;
	}

	public static Music getMusic() {
		return music;
	}

	public static void setMusic(Music music) {
		GameInfo.music = music;
	}

	public static void setTraining(boolean isTraining) {
		GameInfo.isTraining = isTraining;
	}
	
	public static String getAPIkey() {
		return APIkey;
	}

	public static void setAPIkey(String aPIkey) {
		APIkey = aPIkey;
	}

	public static String getFirebaseAddress() {
		return firebaseAddress;
	}

	public static void setFirebaseAddress(String firebaseAddress) {
		GameInfo.firebaseAddress = firebaseAddress;
	}
}
