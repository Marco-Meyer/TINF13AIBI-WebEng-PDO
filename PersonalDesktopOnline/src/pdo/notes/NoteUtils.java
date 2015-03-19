package pdo.notes;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspWriter;


public class NoteUtils {

	static public void printNoteList(JspWriter writer) {
		List<Note> list = NoteList.getInstance().getList();
		Iterator<Note> it = list.iterator();
		Note currentNote;
		try {
			while (it.hasNext()) {
				currentNote = it.next();
				//writer.println("<div class='note' onClick='NoteUtils.clickNote(" + currentNote.getId() + ")'>");
				writer.println("<div class='note'>");
				writer.println(currentNote.getName());
				writer.println("<br>");
				writer.println(currentNote.getText());
				writer.println("</div>");
			}	
		} catch (Exception e) {
			System.out.println("Error while printing the note list");
		}
	}
	
	static public void clickNote(long itemId) {
		System.out.println("clicked on item with id " + itemId);
	}
}
