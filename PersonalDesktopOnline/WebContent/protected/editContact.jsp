<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../styles/ContactForm.css">
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
		 	<input type="text" name="prename" value="<%= (String) session.getAttribute("PRE")%>">
		 	<input type=hidden name=pre value="<%= (String) session.getAttribute("PRE")%>">
		</div> 
		<div>
			<label for="lastName">Nachname: </label>
		 	<input type="text" name="lastName" value="<%= session.getAttribute("LAST")%>"> 
		 	<input type=hidden name=last value="<%=(String) session.getAttribute("LAST")%>">
		</div> 
		<div>
			<label for="mail">E-Mail: </label>
		 	<input type="text" name="mail" value="<%=(String) session.getAttribute("EMAIL")%>">
		 	<input type=hidden name=email value="<%=(String) session.getAttribute("EMAIL")%>"> 
		</div> 
		<div>
			<label for="telephone">Telefon: </label>
		 	<input type="text" name="telephone" value="<%=(String) session.getAttribute("PHONE")%>">
		 	<input type=hidden name=phone value="<%=(String) session.getAttribute("PHONE")%>"> 
		</div> 
		<div>
			<label for="mobilephone">Handy: </label>
		 	<input type="text" name="mobilephone" value="<%=(String) session.getAttribute("MPHONE")%>">
		 	<input type=hidden name=mphone value="<%=(String) session.getAttribute("MPHONE")%>"> 
		</div>
		<div>
			<input type="submit" name="submit" value="�ndern"/> 
		</div>
	</div>
 </form>
</body>
</html>