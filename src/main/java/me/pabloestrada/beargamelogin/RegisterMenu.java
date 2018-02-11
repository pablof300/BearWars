package me.pabloestrada.beargamelogin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import me.pabloestrada.Util.MenuLoader;
import me.pabloestrada.beargamedatabase.DatabaseUtil;
import me.pabloestrada.beargamelevels.LevelStats;
import me.pabloestrada.beargamestats.GameInfo;
import me.pabloestrada.beargamestats.PlayerStats;
import me.pabloestrada.bearwar.BearWarMain;

public class RegisterMenu {

	@FXML
	private Text status;

	@FXML
	private TextField usernameField;
	@FXML
	private TextField passwordField;

	private void setLoadingStatus() {
		status.setText("loading...");
	}

	@FXML
	private void register() {
		setLoadingStatus();
		final Firebase database = DatabaseUtil.getDatabase();
		database.child("users").addListenerForSingleValueEvent(new ValueEventListener() {

			public void onCancelled(FirebaseError data) {
				// TODO Auto-generated method stub

			}

			public void onDataChange(DataSnapshot data) {
				if (usernameField.getText().length() <= 0 || passwordField.getText().length() <= 0) {
					status.setText("Enter a valid username/password");
					return;
				}
				boolean register = true;
				for (DataSnapshot postSnapshot : data.getChildren()) {
					PlayerStats currentStats = postSnapshot.getValue(PlayerStats.class);
					if (usernameField.getText().equals(currentStats.getUsername())) {
						System.out.println("Current username is " + currentStats.getUsername());
						register = false;
						status.setText("Username is taken!");
					}
				}
				if (register) {
					Map<String, Object> farms = new HashMap<String, Object>();
					Map<String, Object>items = new HashMap<String, Object>();
					Map<String, Object>equippedItems = new HashMap<String, Object>();
					int[] ids = { 1, 2, 3, 4 };
					for (int id : ids)
						farms.put("farm_" + id, false);

					items.put("Helmet Armor", "0");
					equippedItems.put("Helmet Armor", "0");
					
					PlayerStats newPlayerStats = new PlayerStats(usernameField.getText(), passwordField.getText(), 1, 0,
							LevelStats.ONE.getStrength(), LevelStats.ONE.getStealth(), LevelStats.ONE.getGatherer(),
							LevelStats.ONE.getDefense(), farms, items, equippedItems);
					database.child("users").child(newPlayerStats.getUsername()).setValue(newPlayerStats);
					BearWarMain.getGameInfo().setPlayerStats(newPlayerStats);
					loadLobby();
				}
				database.goOffline();
			}
		});
	}

	private void loadLobby() {
		Platform.runLater(new Runnable() {

			public void run() {
				GameInfo.setOnline(true);
				LoginScreen.music.stop();
				new MenuLoader("lobby").load();

			}
		});
	}

	@FXML
	private void back() {
		new MenuLoader("loginscreen").load();
	}

}
