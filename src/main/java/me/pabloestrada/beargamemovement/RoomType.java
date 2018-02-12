package me.pabloestrada.beargamemovement;

public enum RoomType {
	HEALING(""), TRAINING_ROOM("training_room"), SHOP_ROOM("main_shop"), LOBBY("lobby");
	
	private String FXMLAddress;
	
	private RoomType(String FXMLAddress) {
		this.FXMLAddress = FXMLAddress;
	}
	
	public String getFXMLAddress() {
		return FXMLAddress;
	}
	
}
