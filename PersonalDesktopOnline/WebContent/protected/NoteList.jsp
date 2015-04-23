<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="pdo.notes.NoteUtils"%>
<%@ page import ="pdo.notes.NoteList"%>
<%@ page import ="pdo.utils.DBConnectionManager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 		
		NoteList noteList;
		if(session.getAttribute("NOTELIST") == null) {
			noteList = DBConnectionManager.getNoteListForUser(request.getUserPrincipal().getName());
			session.setAttribute("NOTELIST", noteList);
		}
		else {
			noteList = (NoteList)session.getAttribute("NOTELIST");
		}
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Notiz-Liste</title>
	<link rel="stylesheet" type="text/css" href="../styles/NotesStyle.css"/>
	<link rel="stylesheet" type="text/css" href="../styles/apprise-v2.css"/>
	<script type="text/javascript" src="../scripts/jquery-1.11.2.js" ></script>
	<script type="text/javascript" src="../scripts/apprise-v2.js" ></script>	
	<script type="text/javascript" src="../scripts/NotesLogic.js" ></script>
</head>
<body>
	<br>
	<%
		NoteUtils.printNoteList(out, noteList);
	%>
	<br>
	<form name="addNewNoteForm" method="post" action="../NotesServlet">
		<input type="hidden" name="id" value=-1>
		<input type="hidden" name="text" value="">
		<input type="submit" class='addNoteButton' name="Submit" value="Notiz hinzufügen">
	</form>
	
	<form action="home.jsp">
    	<input type="submit" class='backButton' value="Zurück">
	</form>
</body>
</html>