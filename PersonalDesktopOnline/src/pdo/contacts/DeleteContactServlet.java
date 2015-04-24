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
		response.sendRedirect("protected/contacts.jsp");
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
        
        DBConnectionManager.deleteContactForUser(userID, prename, lastName, mail, telephone, mobilephone, connection);
        //request.getRequestDispatcher("protected/contacts.jsp").forward(request, response);
        response.sendRedirect("protected/contacts.jsp");

	}

}

