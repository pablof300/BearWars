package me.pabloestrada.beargamestats;

import me.pabloestrada.beargameshop.ShopType;

public class GameInfo {

	private static ShopType currentShop;

	public static ShopType getCurrentShop() {
		return currentShop;
	}

	public static void setCurrentShop(ShopType currentShop) {
		GameInfo.currentShop = currentShop;
	}
	
}
