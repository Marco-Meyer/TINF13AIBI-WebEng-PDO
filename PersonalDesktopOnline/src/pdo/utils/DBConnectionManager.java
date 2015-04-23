package pdo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import pdo.notes.Note;
import pdo.notes.NoteList;
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
    	results.first();
    	settings.setDisplayType(DisplayType.valueOf(results.getString("DisplayType")));
    	settings.setPictureQuality(PictureQuality.valueOf(results.getString("PictureQuality")));
    	
    	String featuresQuery = "SELECT * from features WHERE UserID = '" + results.getString("UserID") + "'";
    	ResultSet features = connection.prepareStatement(featuresQuery).executeQuery();
    	
    	while(features.next()) {
    		settings.getFeatures().add(new Feature(features.getString("Name"), features.getString("Url"), features.getInt("IsEnabled") != 0));
    	}
    	return settings;
    }
    
    public static NoteList getNoteListForUser(String userId) throws SQLException{
    	NoteList list = new NoteList();
    	Connection connection = getDBConnection();
    	String notesQuery = "SELECT * from notes WHERE UserID = '" + userId + "'";
    	ResultSet results = connection.prepareStatement(notesQuery).executeQuery();
    	while(results.next()) {
    		list.createItem(results.getLong("NoteId"), results.getString("Text"));
    	}
    	return list;
    }
    
    public static void saveNoteListForUser(NoteList list, String userId) throws SQLException{
    	Connection connection = getDBConnection();
    	    	
		for(Note note : list.getList()) {
			saveNoteEntry(note, userId, connection);
		}
    }

    public static void deleteNoteEntry(Long noteId, String userId) throws SQLException {
    	Connection connection = getDBConnection();
    	
    	String noteQuery = "DELETE FROM notes " 
				+ "WHERE NoteID = '" + noteId + "' AND UserID = '" + userId + "'";
    	
    	connection.prepareStatement(noteQuery).executeUpdate();
    }
    
    private static void saveNoteEntry(Note note, String userID, Connection connection) throws SQLException {
    	String noteQuery = "INSERT INTO notes (NoteID, UserID, Text) " 
				+ "VALUES ('" + note.getId() + "', '" + userID + "', '" + note.getText() + "') ON DUPLICATE KEY UPDATE UserID=VALUES(UserID), Text=VALUES(Text)"; 
		connection.prepareStatement(noteQuery).executeUpdate();
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