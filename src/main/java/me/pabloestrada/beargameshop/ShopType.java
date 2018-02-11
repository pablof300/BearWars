package me.pabloestrada.beargameshop;

public enum ShopType {

	HELMET_SHOP("Helmet Armor", new String[] {"Horns", "Visor", "Spikes", "Helm" , "Comb"}), CHESTPLATE_SHOP("Chestplate Armor", new String[] {"Brestplate", "Enchantment", "Gorget", "Placard", "Fauld"}), LEGS_SHOP("Legs Armor", new String[] {"Cuisse", "Tasset", "Greaves", "Leggings","Boots"}), ARMS_SHOP(
			"Arms Armor", new String[] {"Couter", "Sword" ,"Gauntlet", "Shield","Glove"}), MISC_SHOP("Misc Items", new String[] {}), TEXTURES_SHOP("Textures", new String[] {});

	private String shopTitle;
	private String[] categories;
	
	private ShopType(String shopTitle, String[] categories) {
		this.shopTitle = shopTitle;
		this.categories = categories;
	}
	
	public String[] getCategories() {
		return categories;
	}
	
	public String getShopTitle() {
		return shopTitle;
	}

}
