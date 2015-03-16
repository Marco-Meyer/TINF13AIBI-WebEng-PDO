package pdo.serialization;

import pdo.settings.Settings;

import com.google.gson.Gson;

public class JSONSerializer {
	
	public static String serializeSettings(Settings settings) {
		try {
			Gson gson = new Gson();
			return gson.toJson(settings);
		} catch(Exception e) {
			throw e;
		}
		
	}
	
	public static Settings deserializeSettings(String jsonString) {
		try {
			Gson gson = new Gson();
			return gson.fromJson(jsonString, Settings.class);
		} catch(Exception e) {
			throw e;
		}
	}
}
