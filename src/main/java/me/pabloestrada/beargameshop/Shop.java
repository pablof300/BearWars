package me.pabloestrada.beargameshop;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.bearwar.BearWarMain;

public class Shop {

	@FXML
	private Text shopTitle;

	@FXML
	private GridPane gridPane;

	@FXML
	private void initialize() {
		ShopType type = BearWarMain.getGameInfo().getCurrentShop();
		shopTitle.setText(type.getShopTitle());
		//Text[] categories = { category_0, category_1, category_2, category_3, category_4 };
		String[] categories = type.getCategories();
		for(int i = 0; i < categories.length; i++) {
			Text currentCategory = new Text();
			currentCategory.setFont(new Font("LCD Solid", 13));
			currentCategory.setWrappingWidth(130);
			currentCategory.setFill(Color.WHITE);
			currentCategory.setTextAlignment(TextAlignment.CENTER);
			currentCategory.setText(categories[i]);
			gridPane.add(currentCategory, i, 0);
			System.out.println(currentCategory);
		}
		
		StackPane pane = new StackPane();
		pane.setPrefHeight(100);
		pane.setPrefWidth(100);
		
		
	}

	@FXML
	private void back() {
		new MenuLoader("main_shop").load();
	}

}
