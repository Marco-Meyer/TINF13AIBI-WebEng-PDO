package pdo.contacts;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;



import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
	   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnectionManager.getDBConnection();
		
		String prename = request.getParameter("prename");
        String lastName = request.getParameter("lastName");
        String mail = request.getParameter("mail");
        String telephone = request.getParameter("telephone");
        String mobilephone = request.getParameter("mobilephone");
               
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into contact(prename, lastname, mail, telephone, mobilephone) values (?,?,?,?,?);");
            ps.setString(1, prename);
            ps.setString(2, lastName);
            ps.setString(3, mail);
            ps.setString(4, telephone);
            ps.setString(5, mobilephone);
             
            ps.execute();

            System.out.println("Writing to DB successful.");	
            request.getRequestDispatcher("contacts.jsp").forward(request, response);

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