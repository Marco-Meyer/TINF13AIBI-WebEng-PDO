package pdo.contacts;

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

import pdo.utils.DBConnectionManager;

/**
 * Servlet implementation class DeleteContactServlet
 */
@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContactServlet() {
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

		Connection connection = DBConnectionManager.getDBConnection();
		String userID = request.getUserPrincipal().getName();
		String prename = request.getParameter("pre");
        String lastName = request.getParameter("last");
        String mail = request.getParameter("email");
        String telephone = request.getParameter("phone");
        String mobilephone = request.getParameter("mphone");
               
        PreparedStatement ps = null;
        try {
        	String query = "DELETE FROM contact WHERE UserID='" + userID + "' AND prename='" + prename + "' AND lastname='" + lastName + "' AND mail='" + mail + "' AND telephone='" + telephone + "' AND mobilephone='" + mobilephone + "'";
            ps = connection.prepareStatement(query);
            ps.execute();

            System.out.println("Deleting from DB successful.");	
            request.getRequestDispatcher("protected/contacts.jsp").forward(request, response);
            
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

