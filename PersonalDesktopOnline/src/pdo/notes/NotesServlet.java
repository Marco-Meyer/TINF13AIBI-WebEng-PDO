package pdo.notes;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pdo.utils.DBConnectionManager;

/**
 * Servlet implementation class NotesServlet
 */
@WebServlet("/NotesServlet")
public class NotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("protected/NoteList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//String name = (String) request.getParameter("name");
		NoteList list = (NoteList) request.getSession().getAttribute("NOTELIST");
		String text = (String) request.getParameter("text");
		long id = Long.parseLong(request.getParameter("id"));
		System.out.println("text: " + text + " id: " + id);
		list.changeItem(id, "", text);
		try {
			DBConnectionManager.saveNoteListForUser(list, request.getUserPrincipal().getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("NOTELIST", list);
		response.sendRedirect("protected/NoteList.jsp");
	}
}
