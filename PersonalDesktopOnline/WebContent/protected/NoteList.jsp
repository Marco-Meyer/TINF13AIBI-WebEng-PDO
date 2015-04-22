<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="pdo.notes.NoteUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Notiz-Liste</title>
	<link rel="stylesheet" type="text/css" href="styles/NotesStyle.css"/>
	<link rel="stylesheet" type="text/css" href="styles/apprise-v2.css"/>
	<script type="text/javascript" src="scripts/jquery-1.11.2.js" ></script>
	<script type="text/javascript" src="scripts/apprise-v2.js" ></script>	
	<script type="text/javascript" src="scripts/NotesLogic.js" ></script>
</head>
<body>
	<br>
	<%
		NoteUtils.printNoteList(out);
	%>
	<br>
	<%-- <form name="noteForm" method="post" action="NotesServlet">
		<h3>Notiz-Name: <input type="text" name="name"></h3>
		<h3>Inhalt: <input type="text" name="text"></h3>
		<h3>ID: <input type="number" name="id" value ="-1"></h3>
		<p><input type="submit" name="Submit" value="Notiz hinzuf�gen"></p>
	</form> --%>
	<form name="addNewNoteForm" method="post" action="NotesServlet">
		<input type="hidden" name="id" value=-1>
		<input type="hidden" name="text" value="">
		<p><input type="submit" name="Submit" value="Notiz hinzuf�gen"></p>
	</form>
	
	<%--<form name="deleteForm" method="post" action="DeleteNoteServlet">
		<h3>Id der zu l�schenden Notiz: <input type="number" name="itemId"></h3>
		<input type="submit" value="L�schen">
	</form>
	<br> --%>
	<form action="home.html">
    	<input type="submit" value="Zur�ck">
	</form>
</body>
</html>