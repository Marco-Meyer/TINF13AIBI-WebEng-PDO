package pdo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;








import pdo.contacts.Contact;
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
    
    static public List<Contact> selectContactsForUserWithBeginningLetter(String UserId, String letter){
		
		Statement statement=null;
		ResultSet resultSet=null;
		String userID;
		String preName;
		String lastName;
		String mail;
		String telephone;
		String mobilephone;
		
		List<Contact> contactList = new ArrayList<>();
		
		Connection connection = DBConnectionManager.getDBConnection();
		
		try {
			statement = connection.createStatement();
			String query = "SELECT * FROM contact WHERE UserID='"+ UserId + "' AND prename like '"+ letter + "%';";
			resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				userID = resultSet.getString("userID");
				preName = resultSet.getString("prename");
				lastName = resultSet.getString("lastname");
				mail = resultSet.getString("mail");
				telephone = resultSet.getString("telephone");
				mobilephone = resultSet.getString("mobilephone");
				Contact contact = new Contact(userID, preName,lastName,mail,telephone,mobilephone);
				contactList.add(contact);
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (resultSet!=null) { 
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				resultSet=null; 
			}    
			if (statement!=null) { 
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				statement=null; 
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}         
			connection=null;
		}
		return contactList;
	}
    
    public static void saveContactForUser(String userID,String prename, String lastName, String mail, String telephone, String mobilephone, Connection connection){ 
    	
    	PreparedStatement ps = null;
    
	    try {	    	
	        ps = connection.prepareStatement("insert into contact(UserID, prename, lastname, mail, telephone, mobilephone) values (?,?,?,?,?,?);");
	        ps.setString(1, userID);
	        ps.setString(2, prename);
	        ps.setString(3, lastName);
	        ps.setString(4, mail);
	        ps.setString(5, telephone);
	        ps.setString(6, mobilephone);
	         
	        ps.execute();
	
	        System.out.println("Writing to DB successful.");	      
	
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }finally{
	        try {
	            ps.close();
	            connection.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        	System.out.println("Error while close connection.");
	        }
	    }
    }
    
    public static void modifyContactForUser(String userID, String prename, String lastName, String mail, String telephone, String mobilephone, String oldPrename, String oldLastName, String oldMail, String oldTelephone, String oldMobilephone, Connection connection){
    	
    	 PreparedStatement ps = null;
	        try {
	        	String query = 
	        			"UPDATE contact SET prename='" + prename + "', lastname='" + lastName + "', mail='" + mail + "', telephone='" + telephone + "', mobilephone='" + mobilephone + "' WHERE userID='" + userID + "' AND prename='" + oldPrename + "' AND lastname='" + oldLastName + "' AND mail='" + oldMail + "' AND telephone='" + oldTelephone + "' AND mobilephone='" + oldMobilephone + "'" ;
	            ps = connection.prepareStatement(query);
	            ps.execute();

	            System.out.println("Updating DB successful.");	

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            try {
	                ps.close();
	                connection.close();
	            } catch (SQLException e) {
	            	e.printStackTrace();
	            	System.out.println("Error while close connection.");
	            }
	        }
    }
    
    
    public static List<Contact> searchContactForUser(String userID, String searchKey, Connection connection){
    	Statement statement=null;
		ResultSet resultSet=null;
		String userId;
		String preName;
		String lastName;
		String mail;
		String telephone;
		String mobilephone;
		
    	List<Contact> searchList = new ArrayList<>();
		try {
			statement = connection.createStatement();
			String query = "SELECT * FROM contact WHERE UserID='"+ userID + "' AND prename like '%"+ searchKey + "%' OR lastname like '%"+ searchKey + "%';";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				userId = resultSet.getString("UserID");
				preName = resultSet.getString("prename");
				lastName = resultSet.getString("lastname");
				mail = resultSet.getString("mail");
				telephone = resultSet.getString("telephone");
				mobilephone = resultSet.getString("mobilephone");
				Contact contact = new Contact(userId, preName,lastName,mail,telephone,mobilephone);
				searchList.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (resultSet!=null) { 
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				resultSet=null; 
			}    
			if (statement!=null) { 
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				statement=null; 
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}         
			connection=null;		
		}
		return searchList;
    }
    
    
    public static void deleteContactForUser(String userID, String prename, String lastName,String mail, String telephone, String mobilephone, Connection connection){
    	
    	PreparedStatement ps = null;
        try {
        	String query = "DELETE FROM contact WHERE UserID='" + userID + "' AND prename='" + prename + "' AND lastname='" + lastName + "' AND mail='" + mail + "' AND telephone='" + telephone + "' AND mobilephone='" + mobilephone + "'";
            ps = connection.prepareStatement(query);
            ps.execute();

            System.out.println("Deleting from DB successful.");	
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
            	e.printStackTrace();
            	System.out.println("Error while close connection.");
            }
        }
    }
    
}