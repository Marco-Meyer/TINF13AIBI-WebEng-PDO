package pdo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pdo.contacts.Contact;
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
    
    public static List<Contact> showContactsLetterForUser(String userID, String letter, Connection connection) throws SQLException {
    	
    	Statement statement=null;
		ResultSet resultSet=null;
//		String userID;
		String preName;
		String lastName;
		String mail;
		String telephone;
		String mobilephone;
		
		List<Contact> nameList = new ArrayList<>();
		
//		Connection connection = DBConnectionManager.getDBConnection();
		
		try {
			statement = connection.createStatement();
			String query = "SELECT * FROM contact WHERE '"+ userID + "' AND prename like '"+ letter + "%';";
			resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				userID = resultSet.getString("userID");
				preName = resultSet.getString("prename");
				lastName = resultSet.getString("lastname");
				mail = resultSet.getString("mail");
				telephone = resultSet.getString("telephone");
				mobilephone = resultSet.getString("mobilephone");
				Contact contact = new Contact(userID, preName,lastName,mail,telephone,mobilephone);
				nameList.add(contact);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (resultSet!=null) { 
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resultSet=null; 
			}    
			if (statement!=null) { 
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				statement=null; 
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}         
			connection=null;
		}
		return nameList;
    }
    
}