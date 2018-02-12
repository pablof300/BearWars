package me.pabloestrada.beargamebattle;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.beargamedatabase.DatabaseUtil;
import me.pabloestrada.beargamelevels.LevelStats;
import me.pabloestrada.beargamemusic.Music;
import me.pabloestrada.beargamemusic.MusicType;
import me.pabloestrada.bearwar.BearWarMain;

public class Battle {

	@FXML
	private Text player_one_username;
	@FXML
	private Text player_two_username;

	@FXML
	private Text player_one_strength;
	@FXML
	private Text player_one_stealth;
	@FXML
	private Text player_one_gatherer;
	@FXML
	private Text player_one_defense;

	@FXML
	private Text player_two_strength;
	@FXML
	private Text player_two_stealth;
	@FXML
	private Text player_two_gatherer;
	@FXML
	private Text player_two_defense;

	@FXML
	private Text player_one_hp_text;
	@FXML
	private ProgressBar player_one_hp;
	@FXML
	private Text player_two_hp_text;
	@FXML
	private ProgressBar player_two_hp;

	@FXML
	private Text status;

	private Opponent opponent;
	private Opponent myPlayer;

	private Turn turn;
	
	@FXML
	private void initialize() {
		turn = Turn.PLAYER;
		
		BearWarMain.getGameInfo().getMusic().setType(MusicType.BATTLE);
		
		if (BearWarMain.getGameInfo().isTraining()) {
			opponent = new Bot(BearWarMain.getGameInfo().getTrainingLevel(), BearWarMain.getGameInfo().getPlayerStats(),
					player_two_hp, player_two_hp_text);
		}
		myPlayer = new Opponent(false, opponent.getStats(), player_one_hp, player_one_hp_text);
		myPlayer.setStats(BearWarMain.getGameInfo().getPlayerStats());

		player_one_username
				.setText(myPlayer.getStats().getUsername() + " (Lvl " + myPlayer.getStats().getLevel() + ")");
		player_two_username
				.setText(opponent.getStats().getUsername() + " (Lvl " + myPlayer.getStats().getLevel() + ")");

		player_one_strength.setText("" + myPlayer.getStats().getStrength());
		player_one_stealth.setText("" + myPlayer.getStats().getStrength());
		player_one_gatherer.setText("" + myPlayer.getStats().getGatherer());
		player_one_defense.setText("" + myPlayer.getStats().getDefense());

		player_two_strength.setText("" + opponent.getStats().getStrength());
		player_two_stealth.setText("" + opponent.getStats().getStrength());
		player_two_gatherer.setText("" + opponent.getStats().getGatherer());
		player_two_defense.setText("" + opponent.getStats().getDefense());
		
		status.setText("Your turn!");
		
		myPlayer.updateHp();
		opponent.updateHp();
	}

	private void nextTurn(String message) {
		status.setText(message);
		if (turn == Turn.OPPONENT)
			turn = Turn.PLAYER;
		else
			turn = Turn.OPPONENT;

		if (myPlayer.getStats().getHp() <= 0) {
			lose();
			return;
		}
		if (opponent.getStats().getHp() <= 0) {
			win();
			return;
		}

		System.out.println("The turn is now of " + turn);
		System.out.println("Is opponent " + opponent.isBot());
		if (turn == Turn.OPPONENT && opponent.isBot()) {
			System.out.println("Running bot!");
			double chance = Math.random();
			if (chance <= 0.5) {
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {

					@Override
					public void run() {
						Platform.runLater(new Runnable() {

							public void run() {
								announceGather(opponent);

							}
						});

					}
				}, 2000);
			} else {
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {

					@Override
					public void run() {
						Platform.runLater(new Runnable() {

							public void run() {
								announceAttack(opponent.attack(), opponent);

							}
						});

					}
				}, 2000);
			}
		}
	}

	private void lose() {
		if (opponent.isBot()) {
			status.setText("Oh NO!!! " + opponent.getStats().getUsername() + " has killed your bear!");
		}

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {

					public void run() {
						returnToLobby();

					}
				});

			}
		}, 2000);
	}

	private void win() {
		if (opponent.isBot()) {
			int exp = (int) (LevelStats.getLevelStats(opponent.getStats().getLevel()).getExp() * 0.2);
			status.setText("You have won " + exp + " exp!");
			myPlayer.getStats().setExp(myPlayer.getStats().getExp() + exp);
			BearWarMain.getGameInfo().setPlayerStats(myPlayer.getStats());
		}
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(new Runnable() {

					public void run() {
						returnToLobby();

					}
				});

			}
		}, 2000);
	}

	private void returnToLobby() {
		sendToLobby();
	}

	@FXML
	private void escape() {
		if (turn == Turn.OPPONENT || turn == Turn.NONE)
			return;
		double chances = (double) opponent.getStats().getStealth() / (double) myPlayer.getStats().getStealth();
		boolean superior = true;
		if (myPlayer.getStats().getStealth() <= opponent.getStats().getStealth()) {
			double multiplicationFactor = 0.5;
			superior = false;
			chances = ((double) myPlayer.getStats().getStealth() / (double) opponent.getStats().getStealth())
					* multiplicationFactor;
		}
		double randomNumber = Math.random();
		if (superior) {
			if (randomNumber > chances) {
				sendToLobby();
			} else {
				nextTurn(myPlayer.getStats().getUsername() + " has tried to escape but failed!");
			}
		} else {
			if (randomNumber < chances) {
				sendToLobby();
			} else {
				nextTurn(myPlayer.getStats().getUsername() + " has tried to escape but failed!");
			}
		}
	}

	private void sendToLobby() {
		BearWarMain.getGameInfo().getMusic().setType(MusicType.LOBBY);
		new MenuLoader("lobby").load();
	}

	@FXML
	private void attack() {
		if (turn == Turn.OPPONENT || turn == Turn.NONE)
			return;
		announceAttack(myPlayer.attack(), myPlayer);
	}

	private void announceGather(Opponent attacker) {
		nextTurn(attacker.getStats().getUsername() + " has gathererd " + (int) attacker.gather()
				+ " hp points from his/her opponent");
		opponent.updateHp();
		myPlayer.updateHp();
	}

	private void announceAttack(double attack, Opponent attacker) {
		if (attack == 0) {
			nextTurn(attacker.getOpponentStats().getUsername() + " has evaded " + attacker.getStats().getUsername()
					+ "'s attack!");
			return;
		}
		nextTurn(attacker.getStats().getUsername() + " has hurt " + attacker.getOpponentStats().getUsername() + " by "
				+ (int) attack + " hp points!");
		if (attacker.equals(myPlayer))
			opponent.updateHp();
		else
			myPlayer.updateHp();
	}

	@FXML
	private void gather() {
		if (turn == Turn.OPPONENT || turn == Turn.NONE)
			return;
		announceGather(myPlayer);
	}

}
