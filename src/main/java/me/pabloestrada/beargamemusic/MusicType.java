package me.pabloestrada.beargamemusic;

public enum MusicType {

	LOADING("loading_music"), LOGIN("login_music"), LOBBY("lobby_music");

	private String musicAddress;
	
	private MusicType(String musicAddress) {
		this.musicAddress = musicAddress;
	}
	
	public String getMusicAddres() {
		return musicAddress;
	}
	
}
