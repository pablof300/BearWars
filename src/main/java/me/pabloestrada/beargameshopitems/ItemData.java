package me.pabloestrada.beargameshopitems;

import java.util.ArrayList;
import java.util.List;

import me.pabloestrada.beargameshop.ShopType;

public enum ItemData {

	PLEBEIAN_HORN("Plebeian Horn", 1000, 1, ShopType.HELMET_SHOP,2,0,0,2),
	HUNTRESS_HORN("Huntress Horn", 1000, 3, ShopType.HELMET_SHOP,1,1,1,1),
	MIDNIGHT_HORN("Midnight Horn", 1000, 8, ShopType.HELMET_SHOP,1,1,1,1),

	LEATHER_VISOR("Leather Visor", 100, 1, ShopType.HELMET_SHOP,1,1,1,1),
	LIBERTY_VISOR("Liberty Visor", 1000, 3, ShopType.HELMET_SHOP, 1,1,1,1),
	PARADISE_VISOR("Paradise Visor", 1000, 8, ShopType.HELMET_SHOP, 1,1,1,1),

	SIMPLE_SPIKES("Simple Spikes", 100, 1, ShopType.HELMET_SHOP,1,1,1,1),
	RUNES_SPIKES("Runes Spikes", 1000, 3, ShopType.HELMET_SHOP, 1,1,1,1),
	TORTURE_SPIKES("Torture Spikes", 1000, 8, ShopType.HELMET_SHOP, 1,1,1,1),

	VOID_HELM("Void Helm", 100, 1, ShopType.HELMET_SHOP, 1,1,1,1),
	ARK_HELM("Ark Helm", 1000, 3,ShopType.HELMET_SHOP, 1,1,1,1),
	IMMUNITY_HELM("Immunity Helm", 1000, 8, ShopType.HELMET_SHOP, 1,1,1,1),

	NORMAL_COMB("Normal Comb", 100, 1, ShopType.HELMET_SHOP, 1,1,1,1),
	DIVINE_COMB("Divine Comb", 1000, 3,ShopType.HELMET_SHOP, 1,1,1,1),
	DEITY_COMB("Deity Comb", 1000, 8, ShopType.HELMET_SHOP, 1,1,1,1),
	
	
	
	CURSED_BRESTPLATE("Cursed Brestplate",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	CRYSTAL_BRESTPLATE("Crystal Brestplate",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	CENTURY_BRESTPLATE("Century Brestplate",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),

	EMBER_ENCHANTMENT("Ember Enchantment",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	EASTERN_ENCHANTMENT("Eastern Enchantment",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	ETERNAL_ENCHANTMENT("Eternal Enchantment",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),

	SHADOW_GORGET("Shadow Gorget",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	SPIRIT_GORGET("Spirit Gorget",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	SACRED_GORGET("Sacred Gorget",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),

	PAPER_PLACARD("Paper Placard",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	PLATINUM_PLACARD("Platinum Placard",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	POISON_PLACARD("Poison Placard",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),


	WOOLEN_FAULD("Woolen Fauld",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	WRETCHED_FAULD("Wretched Fauld",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	WINTER_FAULD("Winter Fauld",1000,1, ShopType.CHESTPLATE_SHOP,1,1,1,1),
	
	
	
	
	
	DAWNING_CUISSE("Dawning Cuisse",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	DIAMOND_CUISSE("Diamond Cuisse",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	DREAMERS_CUISSE("Dreamers Cuisse",1000,1, ShopType.LEGS_SHOP,1,1,1,1),

	TANSY_TASSET("Tansy Tasset",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	THUNDER_TASSET("Thunder Tasset",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	TORMENT_TASSET("Torment Tasset",1000,1, ShopType.LEGS_SHOP,1,1,1,1),

	LUCID_GREAVES("Lucid Greaves",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	LIGHTNING_GREAVES("Lightning Greaves",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	LIBERTY_GREAVES("Liberty Greaves",1000,1, ShopType.LEGS_SHOP,1,1,1,1),

	METAL_LEGGINGS("Metal Leggings",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	MIRAGE_LEGGINGS("Mirage Leggings",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	MOONSTRUCK_LEGGINGS("Moonstruck Leggings",1000,1, ShopType.LEGS_SHOP,1,1,1,1),

	HARVEST_BOOTS("Harvest Boots",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	HIDDEN_BOOTS("Hidden Boots",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	HELLISH_BOOTS("Hellish Boots",1000,1, ShopType.LEGS_SHOP,1,1,1,1),
	
	
	
	
	PRISM_COUTER("Prism Counter",1000,1, ShopType.ARMS_SHOP,1,1,1,1),
	POISINED_COUTER("Poisoned Counter",1000,1, ShopType.ARMS_SHOP,1,1,1,1),
	PHARAOHS_COUTER("Pharaohs Counter",1000,1, ShopType.ARMS_SHOP,1,1,1,1),

	SNOWY_SWORD("Snowy Sword",1000,1, ShopType.ARMS_SHOP,1,1,1,1),
	SMITTEN_SWORD("Smitten Sword",1000,1, ShopType.ARMS_SHOP,1,1,1,1),
	SAPPHIRE_SWORD("Sapphire Sword",1000,1, ShopType.ARMS_SHOP,1,1,1,1),

	ARCTIC_SHIELD("Artic Shield",1000,1, ShopType.ARMS_SHOP,1,1,1,1),
	ACID_SHIELD("Acid Shield",1000,1, ShopType.ARMS_SHOP,1,1,1,1),
	AMBER_SHIELD("Amber Shield",1000,1, ShopType.ARMS_SHOP,1,1,1,1),

	GLASS_GAUNTLET("Glass Gauntlet",1000,1, ShopType.ARMS_SHOP,1,1,1,1),
	GLOWING_GAUNTLET("Glowing Gauntlet",1000,1, ShopType.ARMS_SHOP,1,1,1,1),
	GLORIUS_GAUNTLET("Glorious Gauntlet",1000,1, ShopType.ARMS_SHOP,1,1,1,1),

	VIKING_GLOVE("Viking Glove",1000,1, ShopType.ARMS_SHOP,1,1,1,1),
	VORTEX_GLOVE("Vortex Glove",1000,1, ShopType.ARMS_SHOP,1,1,1,1),
	VICTORY_GLOVE("Victory Glove",1000,1, ShopType.ARMS_SHOP,1,1,1,1);
	
	
	
	

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
