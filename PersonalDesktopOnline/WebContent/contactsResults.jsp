<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="styles/SearchContact.css">
<title>PDO - Kontakte - Suchergebnisse</title>
</head>
<div id="search-header">
		<a href="contacts.jsp" class="button back">Zurück</a> 
		<span id="searchContact">Suchergebnisse</span>
</div>
<body>

<%  
	// retrieve your list from the request, with casting 
	List<String> list = (List<String>) request.getAttribute("nameList");
	
	// print the information about every category of the list
	for(String string : list) {
		out.println("<p>" + string + "</p>");
	}
%>

</body>
</html>