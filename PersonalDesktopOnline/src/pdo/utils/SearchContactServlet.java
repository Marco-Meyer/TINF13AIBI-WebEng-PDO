package pdo.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchContactServlet
 */
@WebServlet("/SearchContactServlet")
public class SearchContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String preName;
		String lastName;
		String fullName;
		List<String> nameList = new ArrayList<>();
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("Where is your MySQL JDBC Driver?");
//			e.printStackTrace();
//		
//		}	 
//		try {
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb","root", "tabea");
//	 
//		} catch (SQLException e) {
//			System.out.println("Connection Failed! Check output console:");
//			e.printStackTrace();
//			
//		}
		Connection connection = DBConnectionManager.getDBConnection();
		
		String searchKey = request.getParameter("search");
		
		try {
			statement = connection.createStatement();
			String query = "SELECT prename, lastname FROM contact WHERE prename like '%"+ searchKey + "%' OR lastname like '%"+ searchKey + "%';";
			resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				preName = resultSet.getString("prename");
				lastName = resultSet.getString("lastname");
				fullName = preName + " " + lastName;			
				nameList.add(fullName);
	
			}

			request.setAttribute("nameList", nameList);
			request.getRequestDispatcher("contactsResults.jsp").forward(request, response);
			
			
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
	}
}


