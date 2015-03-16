package pdo.settings;

import com.google.gson.annotations.SerializedName;

public class Feature {
	
	@SerializedName("enabled")
	private boolean isEnabled;
	private String url;
	private String name;
	
	public Feature() {
		this.isEnabled = false;
		this.url = "";
		this.name = "";
	}
	
	public Feature(String name, String url, boolean enabled) {
		this.isEnabled = enabled;
		this.name = name;
		this.url = url;
	}
	

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
