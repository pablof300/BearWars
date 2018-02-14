package me.pabloestrada.beargameconfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import me.pabloestrada.bearwar.BearWarMain;

public class ConfigurationFile {

	private String firebaseAddress;
	private String APIKey;

	private final String ADDRESS_POINTER = "firebase_address";
	private final String FIREBASE_KEY_POINTER = "firebase_api_key";

	private File getConfigFile() {
		return new File(getPath());
	}

	private String getPath() {
		return "/" + getExecutionPath() + "config.properties";
	}

	private String getExecutionPath() {
		String absolutePath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		absolutePath = absolutePath.substring(0, absolutePath.lastIndexOf("/"));
		absolutePath = absolutePath.replaceAll("%20", " "); // Surely need to do this here
		return absolutePath.substring(1, absolutePath.length()) + "/";
	}

	@SuppressWarnings("static-access")
	public ConfigurationFile() {
		if(!getConfigFile().exists())
			createConfigFile();
		setProperties();
		BearWarMain.getGameInfo().setAPIkey(APIKey);
		BearWarMain.getGameInfo().setFirebaseAddress(firebaseAddress);
	}
	
	private Properties setProperties() {
		Properties props = new Properties();
		try {
		    FileReader reader = new FileReader(getConfigFile());
		    props.load(reader);
		    
		    firebaseAddress = props.getProperty(ADDRESS_POINTER);
		    APIKey = props.getProperty(FIREBASE_KEY_POINTER);
		    
		    reader.close();
		} catch (FileNotFoundException ex) {
			sendWarningMessage();
		} catch (IOException ex) {
			sendWarningMessage();
		}
		return props;
	}

	private void createConfigFile() {
		 Properties properties = new Properties();

		try {
			properties.setProperty("firebase_address", "address");
			properties.setProperty("firebase_api_key", "key");

			properties.store(new FileOutputStream(getPath()), null);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void sendWarningMessage() {
		System.out.println(
				"Invalid firebase address/API key, please configure these correctly in the config.properities file");
	}

	public String getFirebaseAddress() {
		return firebaseAddress;
	}

	public String getAPIKey() {
		return APIKey;
	}

}
