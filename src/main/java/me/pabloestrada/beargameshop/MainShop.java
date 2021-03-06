package me.pabloestrada.beargameshop;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.bearwar.BearWarMain;

public class MainShop {

	@FXML
	private ImageView helmetButton;
	@FXML
	private ImageView chestplateButton;
	@FXML
	private ImageView legsButton;
	@FXML
	private ImageView armsButton;
	
	private HashMap<ImageView, ShopType> imageToShop;
	
	@FXML
	private void initialize() {
		imageToShop = new HashMap<ImageView, ShopType>();
		ImageView[] nodes = {helmetButton, chestplateButton, legsButton, armsButton};
		ShopType[] types = ShopType.values();
		for(int i = 0; i < nodes.length; i ++) 
			imageToShop.put(nodes[i], types[i]);
	}
	
	@FXML
	private void launchShop(MouseEvent e) {
		BearWarMain.getGameInfo().setCurrentShop(imageToShop.get(e.getSource()));
		new MenuLoader("shop").load();
	}
	
	@FXML
	private void back() {
		new MenuLoader("lobby").load();
	}
	
	
}
