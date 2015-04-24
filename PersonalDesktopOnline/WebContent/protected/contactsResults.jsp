<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="java.util.*"%>
<%@ page import ="pdo.contacts.Contact"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="styles/SearchContact.css">
<title>PDO - Kontakte - Suchergebnisse</title>
</head>
<div id="search-header">
		<a href="protected/contacts.jsp" class="button back">Zurück</a> 
		<span id="searchContact">Suchergebnisse</span>
</div>
<body>

<%
	int count=0;
	List<Contact> list = (List<Contact>)request.getAttribute("FIND");
	for(Contact contact : list) {
		contact.showContact(contact,out);
		//contact.editContact(contact, out);
		//contact.deleteContact(contact, out);
		count++;
	}
	 out.println("<p>Ihre Sucheingabe lieferte " + count + " Ergebniss(e).</p>");
%>

</body>
</html>