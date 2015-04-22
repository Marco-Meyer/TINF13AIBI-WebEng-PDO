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
		 	<input type="text" name="prename" value="">
		 	<!-- doesn´t work yet because fullname must be splitted first -->
		</div> 
		<div>
			<label for="lastName">Nachname: </label>
		 	<input type="text" name="lastName" value""> 
		</div> 
		<div>
			<label for="mail">E-Mail: </label>
		 	<input type="text" name="mail" value""> 
		</div> 
		<div>
			<label for="telephone">Telefon: </label>
		 	<input type="text" name="telephone" value""> 
		</div> 
		<div>
			<label for="mobilephone">Handy: </label>
		 	<input type="text" name="mobilephone" value""> 
		</div>
		<div>
			<input type="submit" name="submit" value="Ändern"/> 
		</div>
	</div>
 </form>
</body>
</html>