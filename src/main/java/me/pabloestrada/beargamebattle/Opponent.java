package me.pabloestrada.beargamebattle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.util.Duration;
import me.pabloestrada.beargamelevels.LevelStats;
import me.pabloestrada.beargamestats.PlayerStats;

public class Opponent {

	private boolean bot;

	private PlayerStats opponent;
	private PlayerStats myStats;

	private ProgressBar hp;
	private Text hp_text;

	public Opponent(boolean bot, PlayerStats opponent, ProgressBar hp, Text hp_text) {
		this.bot = bot;
		this.opponent = opponent;
		this.hp = hp;
		this.hp_text = hp_text;
	}

	public boolean isBot() {
		return bot;
	}

	public PlayerStats getOpponentStats() {
		return opponent;
	}

	public PlayerStats getStats() {
		return myStats;
	}

	public void setStats(PlayerStats stats) {
		this.myStats = stats;
	}

	public double attack() {
		double chanceOfEvading = ((double) myStats.getStealth() / (double) opponent.getStealth()) * 0.25;
		if(chanceOfEvading > 1) {
			chanceOfEvading = 0.5;
		}
		double random = Math.random();
		System.out.println("Chance of evading is " + chanceOfEvading);
		System.out.println("Random is " + random);
		if (random < chanceOfEvading) {
			return 0;
		}
		double attack = myStats.getStrength() - (0.2 * (double) opponent.getDefense());
		if(attack < 0)
			attack = 0;
		opponent.setHp(opponent.getHp() - attack);
		if (opponent.getHp() < 0)
			opponent.setHp(0);
		System.out.println("Attack is " + attack);
		return attack;
	}

	public void updateHp() {
		double percentage = myStats.getHp() / (double) LevelStats.getLevelStats(myStats.getLevel()).getHp();

		System.out.println("Percentage is now " + percentage + " and is bot " + bot);

		Timeline timeline = new Timeline();

		KeyValue keyValue = new KeyValue(hp.progressProperty(), percentage);
		KeyFrame keyFrame = new KeyFrame(new Duration(1000), keyValue);
		timeline.getKeyFrames().add(keyFrame);

		timeline.play();

		hp_text.setText(
				" HP: (" + (int) myStats.getHp() + "/" + LevelStats.getLevelStats(myStats.getLevel()).getHp() + ")");
	}

	public double gather() {

		double gather = (0.15 * 3) * LevelStats.getLevelStats(opponent.getLevel()).getHp();
		System.out.println(opponent);
		System.out.println(myStats);
		System.out.println("Opponent gather " + opponent.getGatherer());
		System.out.println("My gather " + myStats.getGatherer());
		System.out.println("Opponent max hp " + LevelStats.getLevelStats(opponent.getLevel()).getHp());
		if (opponent.getGatherer() > 0) {
			gather = (0.15 * (myStats.getGatherer() / opponent.getGatherer()))
					* LevelStats.getLevelStats(opponent.getLevel()).getHp();
		}
		System.out.println("Gather is " + gather);
		myStats.setHp(myStats.getHp() + gather);
		opponent.setHp(opponent.getHp() - gather);

		if (opponent.getHp() < 0)
			opponent.setHp(0);

		if (myStats.getHp() > LevelStats.getLevelStats(myStats.getLevel()).getHp())
			myStats.setHp(LevelStats.getLevelStats(myStats.getLevel()).getHp());

		return gather;
	}

}
