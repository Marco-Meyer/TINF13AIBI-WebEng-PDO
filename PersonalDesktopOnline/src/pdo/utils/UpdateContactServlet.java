package pdo.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateContactServlet
 */
@WebServlet("/UpdateContactServlet")
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContactServlet() {
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
		// TODO Auto-generated method stub
//				Connection connection = null;
//				try {
//					Class.forName("com.mysql.jdbc.Driver");
//				} catch (ClassNotFoundException e) {
//					System.out.println("Where is your MySQL JDBC Driver?");
//					e.printStackTrace();
//					return;
//				}
//			 
//				System.out.println("MySQL JDBC Driver Registered!");
//				
//			 
//				try {
//					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb","root", "tabea");
//			 
//				} catch (SQLException e) {
//					System.out.println("Connection Failed! Check output console:");
//					e.printStackTrace();
//					return;
//				}
//			 
//				if (connection != null) {
//					System.out.println("You made it, take control your database now!");
//				} else {
//					System.out.println("Failed to make connection!");
//				
//				}
		Connection connection = DBConnectionManager.getDBConnection();
			
					String prename = request.getParameter("prename");
			        String lastName = request.getParameter("lastName");
			        String mail = request.getParameter("mail");
			        String telephone = request.getParameter("telephone");
			        String mobilephone = request.getParameter("mobilephone");
			               
			        PreparedStatement ps = null;
			        try {
			            ps = connection.prepareStatement("UPDATE contact SET prename, lastname,...");// Doesn´t work-> fullname must be splitted
			            ps.setString(1, prename);
			            ps.setString(2, lastName);
			            ps.setString(3, mail);
			            ps.setString(4, telephone);
			            ps.setString(5, mobilephone);

			            System.out.println("Updating DB successful.");	
			            request.getRequestDispatcher("contacts.jsp").forward(request, response);

			            System.out.println("Back to JSP.");
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
