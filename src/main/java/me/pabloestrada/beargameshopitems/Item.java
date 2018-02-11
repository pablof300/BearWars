package me.pabloestrada.beargameshopitems;

import javafx.scene.layout.StackPane;

public class Item {
	
	private StackPane pane;
	
	public Item(String name, int price, int level) {
		pane = new StackPane();
		pane.setPrefWidth(100);
		pane.setPrefHeight(100);
	}
}
