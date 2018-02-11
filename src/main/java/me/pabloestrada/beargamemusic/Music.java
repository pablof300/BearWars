package me.pabloestrada.beargamemusic;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Music {

	private MusicType type;
	private static MediaPlayer mediaPlayer;
	
	public Music(MusicType type) {
		this.type = type;
	}

	public void play() {
		Media sound = new Media(getClass().getResource("/" + type.getMusicAddres() + ".mp3").toExternalForm());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	
	public void playAndRepeat() {
		play();
		mediaPlayer.setOnEndOfMedia(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				mediaPlayer.seek(Duration.ZERO);
			}
		});
	}
	
	public void stop() {
		mediaPlayer.stop();
	}

}
