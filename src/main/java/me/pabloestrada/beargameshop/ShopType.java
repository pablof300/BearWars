package me.pabloestrada.beargameshop;

public enum ShopType {

	HELMET_SHOP("Helmet Armor"), CHESTPLATE_SHOP("Chestplate Armor"), LEGS_SHOP("Legs Armor"), ARMS_SHOP(
			"Arms Armor"), MISC_SHOP("Misc Items"), TEXTURES_SHOP("Textures");

	private String shopTitle;

	private ShopType(String shopTitle) {
		this.shopTitle = shopTitle;
	}
	
	public String getShopTitle() {
		return shopTitle;
	}

}
