<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/ContactForm.css">
<title>PDO - Kontakt bearbeiten</title>
</head>
<body>
<div id="form-header">
		<a href="contacts.jsp" class="button delete">Abbrechen</a> 
		<span id="newContact">Kontakt bearbeiten</span>
    </div>
<body>
<form method="POST" action="UpdateContactServlet"> 
	<div id="form">	 	
	 	<div>
			<label for="prename">Vorname: </label>
		 	<input type="text" name="prename" value="<%= request.getAttribute("PRE")%>">
		 	<input type=hidden name=pre value="<%= request.getAttribute("PRE")%>">
		</div> 
		<div>
			<label for="lastName">Nachname: </label>
		 	<input type="text" name="lastName" value="<%= request.getAttribute("LAST")%>"> 
		 	<input type=hidden name=last value="<%= request.getAttribute("LAST")%>">
		</div> 
		<div>
			<label for="mail">E-Mail: </label>
		 	<input type="text" name="mail" value="<%= request.getAttribute("EMAIL")%>">
		 	<input type=hidden name=email value="<%= request.getAttribute("EMAIL")%>"> 
		</div> 
		<div>
			<label for="telephone">Telefon: </label>
		 	<input type="text" name="telephone" value="<%= request.getAttribute("PHONE")%>">
		 	<input type=hidden name=phone value="<%= request.getAttribute("PHONE")%>"> 
		</div> 
		<div>
			<label for="mobilephone">Handy: </label>
		 	<input type="text" name="mobilephone" value="<%= request.getAttribute("MPHONE")%>">
		 	<input type=hidden name=mphone value="<%= request.getAttribute("MPHONE")%>"> 
		</div>
		<div>
			<input type="submit" name="submit" value="Ändern"/> 
		</div>
	</div>
 </form>
</body>
</html>