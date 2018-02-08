package me.pabloestrada.bearwarplayer;

public enum SpriteTexture {
	REGULAR(0);

	private int textureId;

	private SpriteTexture(int textureId) {
		this.textureId = textureId;
	}

	public int getTextureId() {
		return textureId;
	}
}
