package pdo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import pdo.settings.DisplayType;
import pdo.settings.Feature;
import pdo.settings.PictureQuality;
import pdo.settings.Settings;

public class DBConnectionManager {

	private Connection connection;
     
	public DBConnectionManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException{
		Connection connection = null;
    	Class.forName("com.mysql.jdbc.Driver");
    	this.connection = DriverManager.getConnection(dbURL, user, pwd);
    	//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb","root", "tabea");
	}
	     
    public Connection getConnection(){
        return this.connection;
    }
    
    public static void createNewUser(String username, String password, String role) throws SQLException {
    	getDBConnection().prepareStatement("INSERT into users (UserID, UserPW) VALUES ('" + username + "', '" + password + "')").executeUpdate();
    	getDBConnection().prepareStatement("INSERT into roles (UserID, role) VALUES ('" + username + "', '" + role + "')").executeUpdate();
    }
    
    public static void createNewSettings(Settings settings, Connection connection) throws SQLException {
		String settingsQuery = "INSERT into usersettings (UserID, DisplayType, PictureQuality) " 
				+ "VALUES ('" + settings.getUserInfo().getName() + "', '" + settings.getDisplayType().toString()  + "', '" + settings.getPictureQuality().toString() + "')";
		connection.prepareStatement(settingsQuery).executeUpdate();	
		for(Feature feature : settings.getFeatures()) {
			insertFeature(feature, settings.getUserInfo().getName(), connection);
		}	
	}
    
    public static void updateSettings(Settings settings, Connection connection) throws SQLException {
    	String settingsQuery = "INSERT INTO usersettings (UserID, Displaytype, PictureQuality) " + 
    	"VALUES('" + settings.getUserInfo().getName() + "', '" 
    			   + settings.getDisplayType().toString() + "', '" + settings.getPictureQuality().toString() + "') ON DUPLICATE KEY UPDATE DisplayType=VALUES(DisplayType), PictureQuality=(PictureQuality)";
    	connection.prepareStatement(settingsQuery).executeUpdate();
    	
		for(Feature feature : settings.getFeatures()) {
			insertFeature(feature, settings.getUserInfo().getName(), connection);
		}
    }
    
    public static void insertFeature(Feature feature, String userID, Connection connection) throws SQLException {
		String featuresQuery = "INSERT INTO features (UserID, Name, Url, IsEnabled) " 
				+ "VALUES ('" + userID + "', '" + feature.getName() + "', '" + feature.getUrl() + "', " + (feature.isEnabled() ? 1 : 0) + ") ON DUPLICATE KEY UPDATE Url=VALUES(Url), IsEnabled=VALUES(IsEnabled)"; 
		connection.prepareStatement(featuresQuery).executeUpdate();	
	}
    
    
    
    public static Settings getSettingsForUser(String userID, Connection connection) throws SQLException {
    	
    	Settings settings = new Settings();
    	String settingsQuery = "SELECT * from usersettings WHERE UserID = '" + userID + "'";
    	ResultSet results = connection.prepareStatement(settingsQuery).executeQuery();
    	
    	if(results.first()) {
    		settings.setDisplayType(DisplayType.valueOf(results.getString("DisplayType")));
        	settings.setPictureQuality(PictureQuality.valueOf(results.getString("PictureQuality")));
        	String featuresQuery = "SELECT * from features WHERE UserID = '" + results.getString("UserID") + "'";
        	ResultSet features = connection.prepareStatement(featuresQuery).executeQuery();
        	
        	while(features.next()) {
        		settings.getFeatures().add(new Feature(features.getString("Name"), features.getString("Url"), features.getInt("IsEnabled") != 0));
        	}
    	} else {
    		settings = Settings.CreateDefaultSettings(userID);
    		createNewSettings(settings, connection);
    	}
    	return settings;
    }
	
    
    
    public static Connection getDBConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PDODB","root", "tabea");
	 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}	 
		return connection;
	}
}