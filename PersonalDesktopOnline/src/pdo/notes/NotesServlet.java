package pdo.notes;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setAttribute("NOTELIST", NoteList.getInstance().getList());
		request.getRequestDispatcher("NoteList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = (String) request.getParameter("name");
		String text = (String) request.getParameter("text");
		long id = Long.parseLong(request.getParameter("id"));
		NoteList.getInstance().changeItem(id, name, text);
		request.getRequestDispatcher("NoteList.jsp").forward(request, response);
	}
}
