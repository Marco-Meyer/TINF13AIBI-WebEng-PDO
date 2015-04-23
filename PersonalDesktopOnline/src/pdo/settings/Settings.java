package pdo.settings;

import java.util.ArrayList;

public class Settings {
	private DisplayType displayType;
	private PictureQuality pictureQuality;
	private ArrayList<Feature> features;
	private UserInfo userInfo;
	
	public Settings() {
		displayType = DisplayType.Desktop;
		pictureQuality = PictureQuality.High;
		features = new ArrayList<Feature>();
		userInfo = new UserInfo();		
	}
	
	public static Settings CreateTestSettings() {
		Settings output = new Settings();
		output.displayType = DisplayType.Desktop;
		output.pictureQuality = PictureQuality.Medium;
		output.features = new ArrayList<Feature>();
		output.features.add(new Feature("Kalender", "https://www.google.com/calendar?hl=de", true));
		output.features.add(new Feature("Uhrzeit", "www.uhrzeit.org/atomuhr.php", false));
		output.features.add(new Feature("Kontakte", "localhost:8000/PDO/contacts.jsp", false));
		output.userInfo = new UserInfo("FelixH", "felix.helfrich@gmail.com");
		
		return output;
	}
	
	public static Settings CreateDefaultSettings(String username) {
		Settings output = new Settings();
		output.displayType = DisplayType.Desktop;
		output.pictureQuality = PictureQuality.Medium;
		output.features = new ArrayList<Feature>();
		output.features.add(new Feature("Notizen", "localhost:8000/PDO/protected/NoteList.jsp", true));
		output.features.add(new Feature("Kalender", "https://www.google.com/calendar?hl=de", true));
		output.features.add(new Feature("Uhrzeit", "www.uhrzeit.org/atomuhr.php", true));
		output.features.add(new Feature("Kontakte", "localhost:8000/PDO/protected/contacts.jsp", true));
		output.features.add(new Feature("Spiele", "http://www.spielen.com", true));
		output.features.add(new Feature("News", "https://news.google.de/", true));
		output.features.add(new Feature("Medien", "http://www.Dropbox.com", true));
		output.features.add(new Feature("Dokumente", "http://www.Dropbox.com", true));
		output.userInfo = new UserInfo(username, "");
		
		return output;
	}
	
	public boolean featureIsEnables(String name) {
		for(Feature feature : getFeatures()) {
			if(feature.getName().equals(name)) {
				return feature.isEnabled();
			}
		}
		return false;
	}
	
	public String getURLForFeature(String name) {
		for(Feature feature : getFeatures()) {
			if(feature.getName().equals(name)) {
				return feature.getUrl();
			}
		}
		return null;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public DisplayType getDisplayType() {
		return displayType;
	}

	public void setDisplayType(DisplayType displayType) {
		this.displayType = displayType;
	}

	public PictureQuality getPictureQuality() {
		return pictureQuality;
	}

	public void setPictureQuality(PictureQuality pictureQuality) {
		this.pictureQuality = pictureQuality;
	}

	public ArrayList<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<Feature> features) {
		this.features = features;
	}
}
