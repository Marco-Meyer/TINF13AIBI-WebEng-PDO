<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="pdo.notes.NoteUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Notiz-Liste</title>
	<link rel="stylesheet" type="text/css" href="styles/NotesStyle.css"/>
</head>
<body>
	<br>
	<%
		NoteUtils.printNoteList(out);
	%>
	<br>
	<form name="noteForm" method="post" action="NotesServlet">
		<h3>Notiz-Name: <input type="text" name="name"></h3>
		<h3>Inhalt: <input type="text" name="text"></h3>
		<h3>ID: <input type="number" name="id" value ="-1"></h3>
		<p><input type="submit" name="Submit" value="Notiz hinzufügen"></p>
	</form>
	
	<form name="deleteForm" method="post" action="DeleteNoteServlet">
		<h3>Id der zu löschenden Notiz: <input type="number" name="itemId"></h3>
		<input type="submit" value="Löschen">
	</form>
	<br>
	<form action="index.html">
    	<input type="submit" value="Zurück">
	</form>
</body>
</html>