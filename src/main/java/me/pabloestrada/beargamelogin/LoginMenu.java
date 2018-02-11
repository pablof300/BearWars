package me.pabloestrada.beargamelogin;

import java.util.List;

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
import me.pabloestrada.beargamestats.GameInfo;
import me.pabloestrada.beargamestats.PlayerStats;
import me.pabloestrada.bearwar.BearWarMain;

public class LoginMenu {

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
	private void login() {
		setLoadingStatus();
		final Firebase database = DatabaseUtil.getDatabase();
		database.child("users").addListenerForSingleValueEvent(new ValueEventListener() {

			public void onCancelled(FirebaseError data) {
				// TODO Auto-generated method stub

			}

			public void onDataChange(DataSnapshot data) {
				PlayerStats selectedPlayer = null;
				for (DataSnapshot postSnapshot : data.getChildren()) {
					PlayerStats currentStats = postSnapshot.getValue(PlayerStats.class);
					System.out.println("Checking for " + currentStats.getUsername());
					if (usernameField.getText().equals(currentStats.getUsername())
							&& passwordField.getText().equals(currentStats.getPassword())) {
						selectedPlayer = currentStats;
						break;
					}
				}
				if (selectedPlayer == null)
					setStatusToInvalidPassword();
				else {
					BearWarMain.getGameInfo().setPlayerStats(selectedPlayer);
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
				new MenuLoader("lobby").load();
				
			}});
	}

	private void setStatusToInvalidPassword() {
		status.setText("Invalid username/password, please try again!");
	}

	@FXML
	private void back() {
		new MenuLoader("loginscreen").load();
	}

}
