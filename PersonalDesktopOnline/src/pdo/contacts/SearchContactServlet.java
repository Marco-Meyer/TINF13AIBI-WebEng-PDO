package pdo.contacts;

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

import pdo.utils.DBConnectionManager;

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
		Statement statement=null;
		ResultSet resultSet=null;
		String userId;
		String preName;
		String lastName;
		String mail;
		String telephone;
		String mobilephone;
		
		List<Contact> nameList = new ArrayList<>();

		Connection connection = DBConnectionManager.getDBConnection();
		
		String searchKey = request.getParameter("search");
		
		try {
			statement = connection.createStatement();
			String query = "SELECT * FROM contact WHERE UserID='"+ request.getUserPrincipal().getName() + "' AND prename like '%"+ searchKey + "%' OR lastname like '%"+ searchKey + "%';";
			resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				userId = resultSet.getString("UserID");
				preName = resultSet.getString("prename");
				lastName = resultSet.getString("lastname");
				mail = resultSet.getString("mail");
				telephone = resultSet.getString("telephone");
				mobilephone = resultSet.getString("mobilephone");
				Contact contact = new Contact(userId, preName,lastName,mail,telephone,mobilephone);
				nameList.add(contact);
			}

			request.getSession().setAttribute("nameList", nameList);
			request.getRequestDispatcher("protected/contactsResults.jsp").forward(request, response);
			
			
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


