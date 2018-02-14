package me.pabloestrada.beargamedatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.security.token.TokenGenerator;

import me.pabloestrada.beargamestats.PlayerStats;
import me.pabloestrada.bearwar.BearWarMain;

@SuppressWarnings("deprecation")
public class DatabaseUtil {

	private static Firebase database;
	private static boolean valid;

	public static void authenticateDatabase() {
		database = new Firebase(BearWarMain.getGameInfo().getFirebaseAddress());
		Map<String, Object> authPayload = new HashMap<String, Object>();
		authPayload.put("uid", "main_user");

		TokenGenerator tokenGenerator = new TokenGenerator(BearWarMain.getGameInfo().getAPIkey());
		String token = tokenGenerator.createToken(authPayload);
		database.auth(token, new Firebase.AuthListener() {
			public void onAuthError(FirebaseError arg0) {
				System.out.println("Auth error");
				valid = false;
			}

			public void onAuthRevoked(FirebaseError arg0) {
				System.out.println("Auth revoked");
				valid = false;
			}

			public void onAuthSuccess(Object arg0) {
				System.out.println("Auth success");
				valid = true;
			}

		});
		/*
		 * ArrayList<PlayerStats> s = new ArrayList<PlayerStats>(); PlayerStats s1 = new
		 * PlayerStats(); PlayerStats s2 = new PlayerStats(); PlayerStats s3 = new
		 * PlayerStats();
		 * 
		 * s1.setUsername("1"); s2.setUsername("2"); s3.setUsername("3");
		 * 
		 * s1.setPassword("1"); s2.setPassword("2"); s3.setPassword("3");
		 * 
		 * s1.setMoney(1); s2.setMoney(1); s3.setMoney(1);
		 * 
		 * s.add(s1); s.add(s2); s.add(s3);
		 * 
		 * database.child("users").setValue(s);
		 * System.out.println(database.child("users").getKey());
		 */
	}

	public static void updateUserdata() {
		getDatabase().child("users").child(BearWarMain.getGameInfo().getPlayerStats().getUsername())
				.setValue(BearWarMain.getGameInfo().getPlayerStats());
	}

	public static void getUser(String username) {
		database.goOnline();
		database.child("users").child(username).addListenerForSingleValueEvent(new ValueEventListener() {

			public void onCancelled(FirebaseError data) {
				// TODO Auto-generated method stub

			}

			public void onDataChange(DataSnapshot data) {
				System.out.println(data.exists() + " data <-");
				PlayerStats stats = null;
				stats = data.getValue(PlayerStats.class);
				System.out.println(stats);
			}
		});
	}

	public static boolean isValid() {
		return valid;
	}

	public static Firebase getDatabase() {
		database.goOnline();
		return database;
	}

}
