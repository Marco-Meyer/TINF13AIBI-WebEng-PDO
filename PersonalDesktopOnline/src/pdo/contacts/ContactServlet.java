package pdo.contacts;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pdo.notes.NoteList;
import pdo.utils.DBConnectionManager;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("protected/contacts.jsp");
		// TODO Auto-generated method stub
	   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection connection = DBConnectionManager.getDBConnection();
		String userID = request.getUserPrincipal().getName();
		String prename = (String) request.getParameter("prename");
        String lastName = (String) request.getParameter("lastName");
        String mail = (String) request.getParameter("mail");
        String telephone = (String) request.getParameter("telephone");
        String mobilephone = (String) request.getParameter("mobilephone");
        
        DBConnectionManager.saveContactForUser(userID,prename,lastName, mail, telephone,mobilephone, connection);
                        
       //request.getRequestDispatcher("protected/contacts.jsp").forward(request, response);
    	response.sendRedirect("protected/contacts.jsp");
         
	}
}
