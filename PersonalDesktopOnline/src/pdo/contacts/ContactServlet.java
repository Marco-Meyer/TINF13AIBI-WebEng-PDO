package pdo.contacts;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;



import java.util.List;

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
		String prename = request.getParameter("prename");
        String lastName = request.getParameter("lastName");
        String mail = request.getParameter("mail");
        String telephone = request.getParameter("telephone");
        String mobilephone = request.getParameter("mobilephone");
               
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into contact(UserID, prename, lastname, mail, telephone, mobilephone) values (?,?,?,?,?,?);");
            ps.setString(1, userID);
            ps.setString(1, prename);
            ps.setString(2, lastName);
            ps.setString(3, mail);
            ps.setString(4, telephone);
            ps.setString(5, mobilephone);
             
            ps.execute();

            System.out.println("Writing to DB successful.");	
            request.getRequestDispatcher("protected/contacts.jsp").forward(request, response);
            
            List<Contact> contacts0 = DBConnectionManager.showContactsLetterForUser(userID, "0", connection);
            request.getSession().setAttribute("0", contacts0);
            
            List<Contact> contacts1 = DBConnectionManager.showContactsLetterForUser(userID, "1", connection);
            request.getSession().setAttribute("1", contacts1);
            
            List<Contact> contacts2 = DBConnectionManager.showContactsLetterForUser(userID, "2", connection);
            request.getSession().setAttribute("2", contacts2);
            
            List<Contact> contacts3 = DBConnectionManager.showContactsLetterForUser(userID, "3", connection);
            request.getSession().setAttribute("3", contacts3);
            
            List<Contact> contacts4 = DBConnectionManager.showContactsLetterForUser(userID, "4", connection);
            request.getSession().setAttribute("4", contacts4);
            
            List<Contact> contacts5 = DBConnectionManager.showContactsLetterForUser(userID, "5", connection);
            request.getSession().setAttribute("5", contacts5);
            
            List<Contact> contacts6 = DBConnectionManager.showContactsLetterForUser(userID, "6", connection);
            request.getSession().setAttribute("6", contacts6);
            
            List<Contact> contacts7 = DBConnectionManager.showContactsLetterForUser(userID, "7", connection);
            request.getSession().setAttribute("7", contacts7);
            
            List<Contact> contacts8 = DBConnectionManager.showContactsLetterForUser(userID, "8", connection);
            request.getSession().setAttribute("8", contacts8);
            
            List<Contact> contacts9 = DBConnectionManager.showContactsLetterForUser(userID, "9", connection);
            request.getSession().setAttribute("9", contacts9);
            
            List<Contact> contactsA = DBConnectionManager.showContactsLetterForUser(userID, "A", connection);
            request.getSession().setAttribute("A", contactsA);
            
            List<Contact> contactsB = DBConnectionManager.showContactsLetterForUser(userID, "B", connection);
            request.getSession().setAttribute("B", contactsB);
            
            List<Contact> contactsC = DBConnectionManager.showContactsLetterForUser(userID, "C", connection);
            request.getSession().setAttribute("C", contactsC);
            
            List<Contact> contactsD = DBConnectionManager.showContactsLetterForUser(userID, "D", connection);
            request.getSession().setAttribute("D", contactsD);
            
            List<Contact> contactsE = DBConnectionManager.showContactsLetterForUser(userID, "E", connection);
            request.getSession().setAttribute("E", contactsE);
            
            List<Contact> contactsF = DBConnectionManager.showContactsLetterForUser(userID, "F", connection);
            request.getSession().setAttribute("F", contactsF);
            
            List<Contact> contactsG = DBConnectionManager.showContactsLetterForUser(userID, "G", connection);
            request.getSession().setAttribute("G", contactsG);
            
            List<Contact> contactsH = DBConnectionManager.showContactsLetterForUser(userID, "H", connection);
            request.getSession().setAttribute("H", contactsH);
            
            List<Contact> contactsI = DBConnectionManager.showContactsLetterForUser(userID, "I", connection);
            request.getSession().setAttribute("I", contactsI);
            
            List<Contact> contactsJ = DBConnectionManager.showContactsLetterForUser(userID, "J", connection);
            request.getSession().setAttribute("J", contactsJ);
            
            List<Contact> contactsK = DBConnectionManager.showContactsLetterForUser(userID, "K", connection);
            request.getSession().setAttribute("K", contactsK);
            
            List<Contact> contactsL = DBConnectionManager.showContactsLetterForUser(userID, "L", connection);
            request.getSession().setAttribute("L", contactsL);
            
            List<Contact> contactsM = DBConnectionManager.showContactsLetterForUser(userID, "M", connection);
            request.getSession().setAttribute("M", contactsM);
            
            List<Contact> contactsN = DBConnectionManager.showContactsLetterForUser(userID, "N", connection);
            request.getSession().setAttribute("N", contactsN);
            
            List<Contact> contactsO = DBConnectionManager.showContactsLetterForUser(userID, "O", connection);
            request.getSession().setAttribute("O", contactsO);
            
            List<Contact> contactsP = DBConnectionManager.showContactsLetterForUser(userID, "P", connection);
            request.getSession().setAttribute("P", contactsP);
            
            List<Contact> contactsQ = DBConnectionManager.showContactsLetterForUser(userID, "Q", connection);
            request.getSession().setAttribute("Q", contactsQ);
            
            List<Contact> contactsR = DBConnectionManager.showContactsLetterForUser(userID, "R", connection);
            request.getSession().setAttribute("R", contactsR);
            
            List<Contact> contactsS = DBConnectionManager.showContactsLetterForUser(userID, "S", connection);
            request.getSession().setAttribute("S", contactsS);
            
            List<Contact> contactsT = DBConnectionManager.showContactsLetterForUser(userID, "T", connection);
            request.getSession().setAttribute("T", contactsT);
            
            List<Contact> contactsU = DBConnectionManager.showContactsLetterForUser(userID, "U", connection);
            request.getSession().setAttribute("U", contactsU);
            
            List<Contact> contactsV = DBConnectionManager.showContactsLetterForUser(userID, "V", connection);
            request.getSession().setAttribute("V", contactsV);
            
            List<Contact> contactsW = DBConnectionManager.showContactsLetterForUser(userID, "W", connection);
            request.getSession().setAttribute("W", contactsW);
            
            List<Contact> contactsX = DBConnectionManager.showContactsLetterForUser(userID, "X", connection);
            request.getSession().setAttribute("X", contactsX);
            
            List<Contact> contactsY = DBConnectionManager.showContactsLetterForUser(userID, "Y", connection);
            request.getSession().setAttribute("Y", contactsY);
            
            List<Contact> contactsZ = DBConnectionManager.showContactsLetterForUser(userID, "Z", connection);
            request.getSession().setAttribute("Z", contactsZ);

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
