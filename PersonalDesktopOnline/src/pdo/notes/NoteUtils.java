package pdo.notes;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspWriter;


public class NoteUtils {

	static public void printNoteList(JspWriter writer, NoteList noteList) {
		System.out.println("Starting print of note list");
		List<Note> list = noteList.getList();
		Iterator<Note> it = list.iterator();
		Note currentNote;
		try {
			while (it.hasNext()) {
				currentNote = it.next();
				writer.println("<div class='note'>");
				writer.println("<div class='closeButton'"
						+ "onClick='deleteNote(" + currentNote.getId() + ")'>"
						+ "<img class='closeIcon' src='../images/close-button.png' alt='Close'>"
						+ "</div>");
				writer.println("<div class='noteText' "
						+ "id ='note-" + currentNote.getId() + "' "
						+ "onclick=\"createEditBox('Neuer Text:', '" + currentNote.getId() +"')\">");
				writer.println(currentNote.getText());
				writer.println("</div>");
				
				writer.println("</div>");
			}	
		} catch (Exception e) {
			System.out.println("Error while printing the note list");
		}
	}
}
