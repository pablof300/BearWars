package me.pabloestrada.beargameshopitems;

import java.util.ArrayList;
import java.util.List;

import me.pabloestrada.beargameshop.ShopType;

public enum ItemData {

	PLEBEIAN_HORN("Plebeian Horn", 50, 1, ShopType.HELMET_SHOP,0,0,1,1),
	HUNTRESS_HORN("Huntress Horn", 1500, 3, ShopType.HELMET_SHOP,1,1,1,2),
	MIDNIGHT_HORN("Midnight Horn", 1200, 7, ShopType.HELMET_SHOP,1,1,1,1),

	LEATHER_VISOR("Leather Visor", 300, 1, ShopType.HELMET_SHOP,1,0,0,0),
	LIBERTY_VISOR("Liberty Visor", 3000, 4, ShopType.HELMET_SHOP, 2,2,1,1),
	PARADISE_VISOR("Paradise Visor", 5000, 9, ShopType.HELMET_SHOP, 3,0,0,0),

	SIMPLE_SPIKES("Simple Spikes", 800, 2, ShopType.HELMET_SHOP,0,0,1,1),
	RUNES_SPIKES("Runes Spikes", 3000, 3, ShopType.HELMET_SHOP, 1,0,2,1),
	TORTURE_SPIKES("Torture Spikes", 1000, 8, ShopType.HELMET_SHOP, 1,1,1,1),

	VOID_HELM("Void Helm", 100, 1, ShopType.HELMET_SHOP, 1,0,1,1),
	ARK_HELM("Ark Helm", 3000, 3,ShopType.HELMET_SHOP, 1,0,0,3),
	IMMUNITY_HELM("Immunity Helm", 4000, 8, ShopType.HELMET_SHOP, 0,0,3,0),

	NORMAL_COMB("Normal Comb", 100000, 1, ShopType.HELMET_SHOP, 1,1,1,1),
	DIVINE_COMB("Divine Comb", 1000, 3,ShopType.HELMET_SHOP, 1,0,0,1),
	DEITY_COMB("Deity Comb", 9000, 8, ShopType.HELMET_SHOP, 1,1,1,1),
	
	
	
	CURSED_BRESTPLATE("Cursed Brestplate",20,1, ShopType.CHESTPLATE_SHOP,0,0,0,1),
	CRYSTAL_BRESTPLATE("Crystal Brestplate",3000,5, ShopType.CHESTPLATE_SHOP,1,0,1,1),
	CENTURY_BRESTPLATE("Century Brestplate",5000,6, ShopType.CHESTPLATE_SHOP,1,1,0,1),

	EMBER_ENCHANTMENT("Ember Enchantment",1000,1, ShopType.CHESTPLATE_SHOP,2,0,0,0),
	EASTERN_ENCHANTMENT("Eastern Enchantment",3000,1, ShopType.CHESTPLATE_SHOP,3,0,0,1),
	ETERNAL_ENCHANTMENT("Eternal Enchantment",7000,1, ShopType.CHESTPLATE_SHOP,2,0,3,1),

	SHADOW_GORGET("Shadow Gorget",4000,1, ShopType.CHESTPLATE_SHOP,0,3,0,0),
	SPIRIT_GORGET("Spirit Gorget",6000,7, ShopType.CHESTPLATE_SHOP,1,0,0,1),
	SACRED_GORGET("Sacred Gorget",9000,10, ShopType.CHESTPLATE_SHOP,1,1,5,1),

	PAPER_PLACARD("Paper Placard",2000,2, ShopType.CHESTPLATE_SHOP,1,0,0,1),
	PLATINUM_PLACARD("Platinum Placard",9000,5, ShopType.CHESTPLATE_SHOP,0,1,1,1),
	POISON_PLACARD("Poison Placard",10000,10, ShopType.CHESTPLATE_SHOP,0,0,0,4),


	WOOLEN_FAULD("Woolen Fauld",1000,3, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	WRETCHED_FAULD("Wretched Fauld",1000,1, ShopType.CHESTPLATE_SHOP,1,0,0,1),
	WINTER_FAULD("Pablo Fauld",99999,1, ShopType.CHESTPLATE_SHOP,0,0,40,0),
	
	
	
	
	
	DAWNING_CUISSE("Dawning Cuisse",20,1, ShopType.LEGS_SHOP,0,0,0,1),
	DIAMOND_CUISSE("Diamond Cuisse",4000,4, ShopType.LEGS_SHOP,1,1,1,1),
	DREAMERS_CUISSE("Dreamers Cuisse",5000,6, ShopType.LEGS_SHOP,2,0,0,2),

	TANSY_TASSET("Tansy Tasset",1000,3, ShopType.LEGS_SHOP,1,1,1,0),
	THUNDER_TASSET("Thunder Tasset",4000,1, ShopType.LEGS_SHOP,1,0,1,1),
	TORMENT_TASSET("Torment Tasset",5000,1, ShopType.LEGS_SHOP,1,1,0,1),

	LUCID_GREAVES("Lucid Greaves",5000,1, ShopType.LEGS_SHOP,0,1,0,1),
	LIGHTNING_GREAVES("Lightning Greaves",6000,4, ShopType.LEGS_SHOP,1,2,1,1),
	LIBERTY_GREAVES("Liberty Greaves",7000,7, ShopType.LEGS_SHOP,3,1,1,1),

	METAL_LEGGINGS("Metal Leggings",500,1, ShopType.LEGS_SHOP,0,1,0,0),
	MIRAGE_LEGGINGS("Mirage Leggings",4000,3, ShopType.LEGS_SHOP,3,0,0,1),
	MOONSTRUCK_LEGGINGS("Pablo Leggings",80000,10, ShopType.LEGS_SHOP,10,10,10,10),

	HARVEST_BOOTS("Harvest Boots",1000,3, ShopType.LEGS_SHOP,1,3,1,1),
	HIDDEN_BOOTS("Hidden Boots",3000,3, ShopType.LEGS_SHOP,0,1,0,1),
	HELLISH_BOOTS("Hellish Boots",1,10, ShopType.LEGS_SHOP,0,0,0,12),
	
	
	
	
	PRISM_COUTER("Prism Counter",1000,1, ShopType.ARMS_SHOP,0,0,0,1),
	POISINED_COUTER("Poisoned Counter",2000,2, ShopType.ARMS_SHOP,1,1,0,1),
	PHARAOHS_COUTER("Pharaohs Counter",4000,3, ShopType.ARMS_SHOP,1,1,0,1),

	SNOWY_SWORD("Snowy Sword",10,1, ShopType.ARMS_SHOP,1,0,0,0),
	SMITTEN_SWORD("Smitten Sword",4000,4, ShopType.ARMS_SHOP,1,0,0,1),
	SAPPHIRE_SWORD("Sapphire Sword",7000,6, ShopType.ARMS_SHOP,9,1,0,1),

	ARCTIC_SHIELD("Artic Shield",1000,2, ShopType.ARMS_SHOP,1,0,0,2),
	ACID_SHIELD("Acid Shield",4000,4, ShopType.ARMS_SHOP,1,0,0,1),
	AMBER_SHIELD("Amber Shield",1000,5, ShopType.ARMS_SHOP,1,0,1,1),

	GLASS_GAUNTLET("Glass Gauntlet",1000,2, ShopType.ARMS_SHOP,1,1,0,1),
	GLOWING_GAUNTLET("Glowing Gauntlet",1000,4, ShopType.ARMS_SHOP,2,1,1,0),
	GLORIUS_GAUNTLET("Glorious Gauntlet",1000,7, ShopType.ARMS_SHOP,0,1,1,1),

	VIKING_GLOVE("Viking Glove",4000,8, ShopType.ARMS_SHOP,1,1,1,1),
	VORTEX_GLOVE("Vortex Glove",5000,9, ShopType.ARMS_SHOP,1,1,0,1),
	VICTORY_GLOVE("Victory Glove",6000,10, ShopType.ARMS_SHOP,0,10,1,1);
	
	
	
	

	private String name;
	private int price;
	private int level;
	private ShopType type;
	
	private int strength;
	private int stealth;
	private int gatherer;
	private int defense;

	private ItemData(String name, int price, int level, ShopType type, int strength, int stealth, int gatherer, int defense) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.level = level;
		this.strength = strength;
		this.stealth = stealth;
		this.gatherer = gatherer;
		this.defense = defense;
	}
	
	

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getLevel() {
		return level;
	}

	public ShopType getType() {
		return type;
	}

	public static List<ItemData> getData(ShopType type) {
		List<ItemData> data = new ArrayList<ItemData>();
		for (ItemData i : ItemData.values()) {
			if (i.getType() == type)
				data.add(i);
		}
		return data;
	}



	public int getStrength() {
		return strength;
	}

	public int getStealth() {
		return stealth;
	}

	public int getGatherer() {
		return gatherer;
	}

	public int getDefense() {
		return defense;
	}


	
	

}
