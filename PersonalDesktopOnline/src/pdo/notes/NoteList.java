package pdo.notes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NoteList {
	static private NoteList instance;
	private List<Note> list;
	
	private NoteList() {
		super();
		list = new ArrayList<Note>();
	}
	
	static public NoteList getInstance() {
		if (instance == null) {
			instance = new NoteList();
		}
		return instance;
	}
	
	public List<Note> getList() {
		return list;
	}
	
	public void deleteItem(long itemId) {
		Iterator<Note> it = list.iterator();
		Note currentNote;
		boolean deleted = false;
		while (it.hasNext() && !deleted) {
			currentNote = it.next();
			if (currentNote.getId() == itemId) {
				it.remove();
				deleted = true;
			}
		}
		if (deleted == false) {
			System.out.println("Item with id " + itemId + " not found! Deletion was not successful.");
		} else {
			System.out.println("Deletion successfully finished");
		}
	}
	
	public void changeItem(long itemId, String name, String text) {
		if (itemId < 0) {
			list.add(new Note(name, text));
		} else {
			getItem(itemId).changeNote(name, text);
		}
	}
	
	private Note getItem(long itemId) {
		Iterator<Note> it = list.iterator();
		Note currentNote;
		Note result =  new Note();
		boolean found = false;
		while (it.hasNext() && !found) {
			currentNote = it.next();
			if (currentNote.getId() == itemId) {
				result = currentNote;
				found = true;
			}
		}
		if (!found) {
			System.out.println("Item with id + " + itemId + " not found.");
		}
		return result;
	}
}
