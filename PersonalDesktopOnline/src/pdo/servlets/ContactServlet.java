package pdo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
	 
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactdb","root", "tabea");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console:");
			e.printStackTrace();
			return;
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		
		}
//		WORKS!!
//		
//			String prename = request.getParameter("prename");
//	        String lastName = request.getParameter("lastName");
//	        String mail = request.getParameter("mail");
//	        String telephone = request.getParameter("telephone");
//	        String mobilephone = request.getParameter("mobilephone");
//	        
//	        
//	        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
//	        //DBConnectionManager con = new DBConnectionManager(dbUrl,"testUser", "test");
//	       
//	        PreparedStatement ps = null;
//	        try {
//	            ps = con.prepareStatement("insert into contact(prename,lastName,mail, telephone, mobilephone) values (?,?,?,?,?)");
//	            ps.setString(1, prename);
//	            ps.setString(2, lastName);
//	            ps.setString(3, mail);
//	            ps.setString(4, telephone);
//	            ps.setString(5, mobilephone);
//	             
//	            ps.execute();
//	             
//	            //forward to login page to login
//	            //RequestDispatcher rd = getServletContext().getRequestDispatcher("contacts.jsp");
//	            PrintWriter out= response.getWriter();
//	            out.println("<font color=green>Writing to DB successful.</font>");
//	            //rd.include(request, response);
//	            request.getRequestDispatcher("contacts.jsp").forward(request, response);
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	            //logger.error("Database connection problem");
//	            //throw new ServletException("DB Connection problem.");
//	        }finally{
//	            try {
//	                ps.close();
//	            } catch (SQLException e) {
//	            	e.printStackTrace();
//	            	System.out.println("Error ps.close");
//	                //logger.error("SQLException in closing PreparedStatement");
//	            }
//	        }
//	        Statement sqlStatement;
//			try {
//				sqlStatement = con.createStatement();
//			
//	        // Generate the SQL query. 
//	        String query = "SELECT prename, lastname FROM contact"; 
//	        // Get the query results and display them. 
//	        ResultSet sqlResult = null;
//	       
//	        while(sqlResult.next()) { 
//		       
//		        String fName;
//		        String lName;
//				
//					sqlResult = sqlStatement.executeQuery(query);
//					fName = sqlResult.getString("prename");
//					lName = sqlResult.getString("lastname");
//					System.out.println( fName + ", " + lName);
//				}
//	        sqlResult.close();
//			con.close();
//	        } catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
		
	      response.setContentType("text/html;charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	 
	     
	      Statement  stmt = null;
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html>");
	         out.println("<head><title>Qurey Servlet</title></head>");
	         out.println("<body>");
	 
	         // Get a connection from the pool
	         
	 
	         // Normal JBDC programming hereafter. Close the Connection to return it to the pool
	         stmt = connection.createStatement();
	         ResultSet rset = stmt.executeQuery("SELECT prename, lastname FROM contact");
	         int count=0;
	         while(rset.next()) {
	            out.println("<p>" + rset.getString("prename") + ", "
	                  + rset.getString("lastname") + "</p>");
	            ++count;
	         }
	         out.println("<p>==== " + count + " rows found =====</p>");
	         out.println("</body></html>");
	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      } finally {
	         out.close();
	         try {
	            if (stmt != null) stmt.close();
	            if (connection != null) connection.close();  // return to pool
	         } catch (SQLException ex) {
	             ex.printStackTrace();
	         }
	      }
	   }
	        

	        
	        
	        
	        
	        
//	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
