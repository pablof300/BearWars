package me.pabloestrada.beargameshop;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.bearwar.BearWarMain;

public class Shop {

	@FXML
	private Text shopTitle;
	
	@FXML
	private void initialize() {
		shopTitle.setText(BearWarMain.getGameInfo().getCurrentShop().getShopTitle());
	}
	
	@FXML
	private void back() {
		new MenuLoader("main_shop").load();
	}
	
}
