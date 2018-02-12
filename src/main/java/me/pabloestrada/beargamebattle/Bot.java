package me.pabloestrada.beargamebattle;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import me.pabloestrada.beargamelevels.LevelStats;
import me.pabloestrada.beargamestats.PlayerStats;

public class Bot extends Opponent {

	public Bot(int level, PlayerStats opponent, ProgressBar hp, Text hp_text) {
		super(true, opponent,hp, hp_text);
		
		LevelStats levelStats = LevelStats.getLevelStats(level);
		
		Map<String, Object> farms = new HashMap<String, Object>();
		Map<String, Object>items = new HashMap<String, Object>();
		Map<String, Object>equippedItems = new HashMap<String, Object>();
		int[] ids = { 1, 2, 3, 4 };
		for (int id : ids)
			farms.put("farm_" + id, false);

		items.put("Helmet Armor", "");
		equippedItems.put("Helmet Armor", "");
		
		
		PlayerStats botStats = new PlayerStats("CPU", "None", 0, levelStats.getHp(), levelStats.getLevel(), 0,
				levelStats.getStrength() * 2, levelStats.getStealth() *2, level,
				levelStats.getDefense() * 2, farms, items, equippedItems);
		setStats(botStats);
	}

	
}
