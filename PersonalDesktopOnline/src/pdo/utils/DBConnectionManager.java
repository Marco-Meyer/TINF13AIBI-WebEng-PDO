package pdo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}