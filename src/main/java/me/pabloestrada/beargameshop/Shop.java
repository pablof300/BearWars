package me.pabloestrada.beargameshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.beargamedatabase.DatabaseUtil;
import me.pabloestrada.beargameshopitems.ItemData;
import me.pabloestrada.beargamestats.PlayerStats;
import me.pabloestrada.bearwar.BearWarMain;

public class Shop {

	@FXML
	private Text shopTitle;

	@FXML
	private GridPane gridPane;

	@FXML
	private StackPane item_0;
	@FXML
	private StackPane item_1;
	@FXML
	private StackPane item_2;
	@FXML
	private StackPane item_3;
	@FXML
	private StackPane item_4;
	@FXML
	private StackPane item_5;
	@FXML
	private StackPane item_6;
	@FXML
	private StackPane item_7;
	@FXML
	private StackPane item_8;
	@FXML
	private StackPane item_9;
	@FXML
	private StackPane item_10;
	@FXML
	private StackPane item_11;
	@FXML
	private StackPane item_12;
	@FXML
	private StackPane item_13;
	@FXML
	private StackPane item_14;

	@FXML
	private Text strengthNode;
	@FXML
	private Text stealthNode;
	@FXML
	private Text defenseNode;
	@FXML
	private Text gathererNode;
	@FXML
	private Text fishNode;

	@FXML
	private Text status;

	private StackPane[] itemNodes;

	private HashMap<StackPane, Integer> nodeToItemId;
	private HashMap<Integer, Boolean> unlockedMap;
	private List<Integer> equippedItems;

	private HashMap<Integer, Text> itemStatusLabels;

	private List<ItemData> items;

	private ShopType type;

	@FXML
	private void initialize() {
		equippedItems = new ArrayList<Integer>();
		itemStatusLabels = new HashMap<Integer, Text>();
		itemNodes = new StackPane[] { item_0, item_1, item_2, item_3, item_4, item_5, item_6, item_7, item_8, item_9,
				item_10, item_11, item_12, item_13, item_14 };
		nodeToItemId = new HashMap<StackPane, Integer>();
		unlockedMap = new HashMap<Integer, Boolean>();
		for (int i = 0; i < itemNodes.length; i++)
			nodeToItemId.put(itemNodes[i], i);

		type = BearWarMain.getGameInfo().getCurrentShop();
		items = ItemData.getData(type);

		if (BearWarMain.getGameInfo().getPlayerStats().getItems().containsKey(type.getShopTitle())) {
			String[] unlockedItems = ((String) BearWarMain.getGameInfo().getPlayerStats().getItems()
					.get(type.getShopTitle())).split(",");
			for (int itemId = 0; itemId < nodeToItemId.size(); itemId++) {
				unlockedMap.put(itemId, false);
			}
			for (String currentItem : unlockedItems) {
				if (currentItem.equals(""))
					continue;
				unlockedMap.put(Integer.parseInt(currentItem), true);
			}
		} else {
			for (int itemId = 0; itemId < nodeToItemId.size(); itemId++) {
				unlockedMap.put(itemId, false);
			}
		}

		if (BearWarMain.getGameInfo().getPlayerStats().getEquippedItems().containsKey(type.getShopTitle())) {
			String[] unlockedItems = ((String) BearWarMain.getGameInfo().getPlayerStats().getEquippedItems()
					.get(type.getShopTitle())).split(",");
			for (String currentItem : unlockedItems) {
				System.out.println("Unlocking " + currentItem);
				if (currentItem.equals(""))
					continue;
				equippedItems.add(Integer.parseInt(currentItem));
			}
		}

		shopTitle.setText(type.getShopTitle());
		loadSubcategories(type);
		loadItems(type);
		updateStatsNodes();
	}

	private void updateStatsNodes() {
		PlayerStats stats = BearWarMain.getGameInfo().getPlayerStats();
		strengthNode.setText("" + stats.getStrength());
		stealthNode.setText("" + stats.getStealth());
		defenseNode.setText("" + stats.getDefense());
		gathererNode.setText("" + stats.getGatherer());
		fishNode.setText("" + (int) stats.getMoney());
	}

	@FXML
	private void itemClicked(MouseEvent e) {
		int selectedItem = nodeToItemId.get(e.getSource());
		ItemData itemData = items.get(selectedItem);
		if (equippedItems.contains(selectedItem)) {
			unequipItem(selectedItem, itemData);
		} else if (unlockedMap.get(selectedItem)) {
			equipItem(selectedItem, itemData, true);
		} else {
			if (BearWarMain.getGameInfo().getPlayerStats().getMoney() >= itemData.getPrice()) {
				if (BearWarMain.getGameInfo().getPlayerStats().getLevel() >= itemData.getLevel()) {
					buyAndEquipItem(selectedItem, itemData);
				} else
					status.setText("You need to level up more to get this item!");
			} else
				status.setText("You can't afford this");
		}
	}

	private void buyAndEquipItem(int id, ItemData data) {
		String items = "";
		unlockedMap.put(id, true);
		for (Integer i : unlockedMap.keySet()) {
			if (unlockedMap.get(i))
				items = items + i + ",";
		}
		BearWarMain.getGameInfo().getPlayerStats().getItems().put(type.getShopTitle(), items);
		BearWarMain.getGameInfo().getPlayerStats().setMoney(BearWarMain.getGameInfo().getPlayerStats().getMoney() - data.getPrice());
		equipItem(id, data, false);
		status.setText("You have bought and equipped " + data.getName());
	}

	private void equipItem(int id, ItemData data, boolean displayMsg) {
		equippedItems.add(id);
		String updatedEquipment = "";
		for (int i : equippedItems)
			updatedEquipment = updatedEquipment + "," + i;
		BearWarMain.getGameInfo().getPlayerStats().getEquippedItems().put(type.getShopTitle(), updatedEquipment);
		BearWarMain.getGameInfo().getPlayerStats().updateStats(1 * data.getStrength(), 1 * data.getStealth(),
				1 * data.getGatherer(), 1 * data.getDefense());
		DatabaseUtil.updateUserdata();
		if (displayMsg)
			status.setText("You have equipped " + data.getName());
		itemStatusLabels.get(id).setText("equipped");
		updateStatsNodes();
	}

	private void unequipItem(int id, ItemData data) {
		equippedItems.remove(new Integer(id));
		String updatedEquipment = "";
		for (int i : equippedItems)
			updatedEquipment = updatedEquipment + "," + i;
		BearWarMain.getGameInfo().getPlayerStats().getEquippedItems().put(type.getShopTitle(), updatedEquipment);
		BearWarMain.getGameInfo().getPlayerStats().updateStats(-1 * data.getStrength(), -1 * data.getStealth(),
				-1 * data.getGatherer(), -1 * data.getDefense());
		DatabaseUtil.updateUserdata();
		status.setText("You have unequipped " + data.getName());
		itemStatusLabels.get(id).setText("click to equip");
		updateStatsNodes();

	}

	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
		for (Node node : gridPane.getChildren()) {
			if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
				return node;
			}
		}
		return null;
	}

	private void loadItems(ShopType type) {
		int counter = 0;
		for (StackPane pane : itemNodes) {
			pane.getChildren().add(new Text());
			ImageView background = new ImageView(
					new Image(getClass().getResource("/" + "shop_item.png").toExternalForm()));
			background.setFitWidth(100);
			background.setFitHeight(100);
			pane.getChildren().add(background);

			ItemData currentData = items.get(counter);
			System.out.println("Adding " + currentData.getName() + " to " + pane);
			Text[] textNodes = { new Text(), new Text(), new Text(), new Text() };
			int[] position = { -77, -52, -28, 0 };
			String[] texts = { currentData.getName(), "$" + currentData.getPrice(), "" + currentData.getLevel(),
					"locked" };

			for (int i = 0; i < textNodes.length; i++) {
				Text currentText = textNodes[i];
				currentText.setTextAlignment(TextAlignment.CENTER);
				currentText.setWrappingWidth(100);
				currentText.setFont(new Font("LCD Solid", 10));
				currentText.setText(texts[i]);
				pane.setMargin(currentText, new Insets(position[i], 0, 0, 0));
				
				if (i == 3) {
					System.out.println("1. " + equippedItems);
					System.out.println("2. "+ counter);
					itemStatusLabels.put(counter, currentText);
					currentText.setFill(Color.GRAY);
					if (equippedItems.contains(counter)) {
						currentText.setText("equipped");
					} else if (unlockedMap.get(counter)) {
						currentText.setText("click to equip");
					} else
						currentText.setText("click to buy");
				} else
					currentText.setFill(Color.WHITE);
				pane.getChildren().add(currentText);
			}
			System.out.println("Children are " + pane.getChildren());

			int[] statsPositions = { 79, 30, -23, -77 };
			String[] statsTexts = { "" + currentData.getStrength(), "" + currentData.getStealth(),
					"" + currentData.getGatherer(), "" + currentData.getDefense() };
			for (int i = 0; i < 4; i++) {
				Text currentText = new Text();
				currentText.setTextAlignment(TextAlignment.CENTER);
				currentText.setWrappingWidth(20);
				currentText.setFill(Color.WHITE);
				currentText.setFont(new Font("LCD Solid", 10));
				currentText.setText(statsTexts[i]);
				pane.getChildren().add(currentText);
				pane.setMargin(currentText, new Insets(80, statsPositions[i], 0, 0));
			}

			counter++;
		}
	}

	private void loadSubcategories(ShopType type) {
		String[] categories = type.getCategories();
		for (int i = 0; i < categories.length; i++) {
			Text currentCategory = new Text();
			currentCategory.setFont(new Font("LCD Solid", 13));
			currentCategory.setWrappingWidth(130);
			currentCategory.setFill(Color.WHITE);
			currentCategory.setTextAlignment(TextAlignment.CENTER);
			currentCategory.setText(categories[i]);
			gridPane.add(currentCategory, i, 0);
		}
	}

	@FXML
	private void back() {
		new MenuLoader("main_shop").load();
	}

}
