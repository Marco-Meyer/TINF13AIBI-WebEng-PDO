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
