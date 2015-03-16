package pdo.settings;

public class UserInfo {
	private String name;
	private String eMail;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public UserInfo() {
		name = "";
		eMail = "";
	}
	
	public UserInfo(String name, String eMail) {
		this.name = name;
		this.eMail = eMail;
	}
	
}
