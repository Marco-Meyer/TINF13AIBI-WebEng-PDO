package pdo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowContacts {
	static public List<String> showContacts(String letter){
		
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String preName;
		String lastName;
		String fullName;
		List<String> nameList = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		
		}	 
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb","root", "tabea");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console:");
			e.printStackTrace();
			
		}
		
		try {
			statement = connection.createStatement();
			String query = "SELECT prename, lastname FROM contact WHERE prename like '"+ letter + "%';";
			resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				preName = resultSet.getString("prename");
				lastName = resultSet.getString("lastname");
				fullName = preName + " " + lastName;			
				nameList.add(fullName);
	
			}

//			request.setAttribute("nameList", nameList);
//			request.getRequestDispatcher("contacts.jsp").forward(request, response);
			
			
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


