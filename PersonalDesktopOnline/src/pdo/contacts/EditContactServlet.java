package pdo.contacts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditContactServlet
 */
@WebServlet("/EditContactServlet")
public class EditContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditContactServlet() {
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
		String userID = request.getUserPrincipal().getName();
		String pre = request.getParameter("pre");
		String last = request.getParameter("last");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String mphone = request.getParameter("mphone");
		
		request.getSession().setAttribute("USER", userID);
		request.getSession().setAttribute("PRE", pre);
		request.getSession().setAttribute("LAST", last);
		request.getSession().setAttribute("EMAIL", email);
		request.getSession().setAttribute("PHONE", phone);
		request.getSession().setAttribute("MPHONE", mphone);
		
		request.getRequestDispatcher("protected/editContact.jsp").forward(request, response);
	}

}
