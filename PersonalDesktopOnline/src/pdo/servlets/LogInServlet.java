package pdo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import pdo.settings.Settings;
import pdo.utils.DBConnectionManager;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
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
		HttpSession session = request.getSession();
	
		String UserID = request.getParameter("id");
		String UserPW = request.getParameter("pw");
		
		Connection connection = DBConnectionManager.getDBConnection();
		try {
			//if user does not exist new user is created
			if(!isValidUser(UserID, UserPW, connection)) {
				response.sendRedirect("index.html");
			}
			else {

				//set session
				session.setAttribute("UserID", UserID);
				session.setAttribute("SETTINGS", DBConnectionManager.getSettingsForUser(UserID, connection));

				
				//redirect
				response.sendRedirect("home.html");
			}	
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	private boolean isValidUser(String id, String pw, Connection connection) throws SQLException {
		String query = "SELECT UserID, UserPW from users WHERE UserID = '" + id + "'";
		ResultSet results = connection.prepareStatement(query).executeQuery();
		if(results.first()) {
			return results.getString("UserPW").equals(pw);
		}
		createNewUser(id, pw, connection);
		return true;
	}
	
	private void createNewUser(String id, String pw, Connection connection) throws SQLException {
		
		String query = "INSERT into users (UserID, UserPW) VALUES ('" + id + "', '" + pw + "')";
		connection.prepareStatement(query).executeUpdate();
		DBConnectionManager.createNewSettings(Settings.CreateDefaultSettings(id), connection);
	}

}
