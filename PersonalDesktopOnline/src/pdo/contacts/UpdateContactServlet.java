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

			Connection connection = DBConnectionManager.getDBConnection();
			
			String userID = request.getUserPrincipal().getName();
			String prename = request.getParameter("prename");
	        String lastName = request.getParameter("lastName");
	        String mail = request.getParameter("mail");
	        String telephone = request.getParameter("telephone");
	        String mobilephone = request.getParameter("mobilephone");
	        
	        String oldPrename = request.getParameter("pre");
	        String oldLastName = request.getParameter("last");
	        String oldMail = request.getParameter("email");
	        String oldTelephone = request.getParameter("phone");
	        String oldMobilephone = request.getParameter("mphone");
			             
	        DBConnectionManager.modifyContactForUser(userID, prename,lastName,mail,telephone, mobilephone, oldPrename, oldLastName, oldMail, oldTelephone, oldMobilephone,  connection);

	        response.sendRedirect("protected/contacts.jsp");

	}

}