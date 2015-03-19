package pdo.notes;

public class Note {
	private String name;
	private long id;
	private String text;
	private long position;
	static private long idCounter = 0;
	
	public String getName() {
		return name;
	}
	
	public long getId() {
		return id;
	}
	
	public String getText() {
		return text;
	}

	public long getPosition() {
		return position;
	}

	public Note() {
		super();
		this.name = "";
		this.text = "";
		this.id = -1;
		this.position = 0;
	}
	
	public Note(String name, String text) {
		super();
		this.name = name;
		this.id = idCounter;
		idCounter++;
		this.text = text;
		this.position = 0;
	}
	
	public void changeNote(String newName, String newText) {
		this.name = newName;
		this.text = newText;
	}

	@Override
	public String toString() {
		return "name = " + name + " text = " + text;
	}
	
	
}
