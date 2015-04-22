<!DOCTYPE html>
<html>
<%@ page import ="java.util.*"%>
<%@ page import ="pdo.utils.ShowContacts"%>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="styles/ContactsStyle.css">
	<script type="text/javascript" src="scripts/ContactsLogic.js" ></script>
<title>PDO - Kontakte</title>
</head>
	<div id="contacts-header">
		<a href="home.html" class="button back">Zurück</a> 
		<span id="contacts">Kontakte</span>
		<form method="POST" action="SearchContactServlet">
			<input type="text" name="search" placeholder="Suchen"> 
			<input type="submit" name="submit" value="Los"/>
		</form>
		
		<a href="newContact.html" class="button add">Hinzufügen</a> 
    </div>
	<div id="contacts-tabbar-container" >

	<!-- border-right: 1px solid #A5A5A5; -->
	
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(0)"><p class="tab-label"><a href="##">#</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(0)"><p class="tab-label"><a href="#A">A</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(1)"><p class="tab-label"><a href="#B">B</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(2)"><p class="tab-label"><a href="#C">C</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(3)"><p class="tab-label"><a href="#D">D</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(4)"><p class="tab-label"><a href="#E">E</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(5)"><p class="tab-label"><a href="#F">F</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(6)"><p class="tab-label"><a href="#G">G</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(7)"><p class="tab-label"><a href="#H">H</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(8)"><p class="tab-label"><a href="#I">I</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(9)"><p class="tab-label"><a href="#J">J</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(10)"><p class="tab-label"><a href="#K">K</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(11)"><p class="tab-label"><a href="#L">L</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(12)"><p class="tab-label"><a href="#M">M</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(13)"><p class="tab-label"><a href="#N">N</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(14)"><p class="tab-label"><a href="#O">O</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(15)"><p class="tab-label"><a href="#P">P</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(16)"><p class="tab-label"><a href="#Q">Q</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(17)"><p class="tab-label"><a href="#R">R</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(18)"><p class="tab-label"><a href="#S">S</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(19)"><p class="tab-label"><a href="#T">T</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(20)"><p class="tab-label"><a href="#U">U</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(21)"><p class="tab-label"><a href="#V">V</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(22)"><p class="tab-label"><a href="#W">W</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(23)"><p class="tab-label"><a href="#X">X</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(24)"><p class="tab-label"><a href="#Y">Y</a></p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(25)"><p class="tab-label"><a href="#Z">Z</a></p></div>
		<!-- Elemente bleiben an der gleichen Stelle beim Scrollen?! -> bilden Scrollbar, sodass Link nebendran gleich bleibt -->
	</div>
	
	<div id="contacts-categories-container">
		<div id="letter-container" class="contacts-letter">
			<h2 id="#">#</h2>
			<%  

				List<String> list0 = ShowContacts.showContacts("0");
				for(String string : list0) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			
				List<String> list1 = ShowContacts.showContacts("1");
				for(String string : list1) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
				
			%>
			<h2 id="A">A</h2>
			<%  
				List<String> listA = ShowContacts.showContacts("A");
				for(String string : listA) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
					//out.println("<a href=contact.jsp class=button delete onclick=deleteContact()>Löschen</a>");
					out.println("<form method=POST action=DeleteContactServlet>");
					out.println("<input type=submit name=submit value=Löschen />");
					out.println("</form>");
				}
			%>
			<h2 id="B">B</h2>
			<%  
				List<String> listB = ShowContacts.showContacts("B");
				for(String string : listB) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="C">C</h2>
			<%  
				List<String> listC = ShowContacts.showContacts("C");
				for(String string : listC) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="D">D</h2>
			<%  
				List<String> listD = ShowContacts.showContacts("D");
				for(String string : listD) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="E">E</h2>
			<%  
				List<String> listE = ShowContacts.showContacts("E");
				for(String string : listE) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="F">F</h2>
			<%  
				List<String> listF = ShowContacts.showContacts("F");
				for(String string : listF) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="G">G</h2>
			<%  
				List<String> listG = ShowContacts.showContacts("G");
				for(String string : listG) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="H">H</h2>
			<%  
				List<String> listH = ShowContacts.showContacts("H");
				for(String string : listH) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="I">I</h2>
			<%  
				List<String> listI = ShowContacts.showContacts("I");
				for(String string : listI) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="J">J</h2>
			<%  
				List<String> listJ = ShowContacts.showContacts("J");
				for(String string : listJ) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="K">K</h2>
			<%  
				List<String> listK = ShowContacts.showContacts("K");
				for(String string : listK) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="L">L</h2>
			<%  
				List<String> listL = ShowContacts.showContacts("L");
				for(String string : listL) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="M">M</h2>
			<%  
				List<String> listM = ShowContacts.showContacts("M");
				for(String string : listM) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="N">N</h2>
			<%  
				List<String> listN = ShowContacts.showContacts("N");
				for(String string : listN) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="O">O</h2>
			<%  
				List<String> listO = ShowContacts.showContacts("O");
				for(String string : listO) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="P">P</h2>
			<%  
				List<String> listP = ShowContacts.showContacts("P");
				for(String string : listP) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="Q">Q</h2>
			<%  
				List<String> listQ = ShowContacts.showContacts("Q");
				for(String string : listQ) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="R">R</h2>
			<%  
				List<String> listR = ShowContacts.showContacts("R");
				for(String string : listR) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="S">S</h2>
			<%  
				List<String> listS = ShowContacts.showContacts("S");
				for(String string : listS) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="T">T</h2>
			<%  
				List<String> listT = ShowContacts.showContacts("T");
				for(String string : listT) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="U">U</h2>
			<%  
				List<String> listU = ShowContacts.showContacts("U");
				for(String string : listU) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="V">V</h2>
			<%  
				List<String> listV = ShowContacts.showContacts("V");
				for(String string : listV) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="W">W</h2>
			<%  
				List<String> listW = ShowContacts.showContacts("W");
				for(String string : listW) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="X">X</h2>
			<%  
				List<String> listX = ShowContacts.showContacts("X");
				for(String string : listX) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="Y">Y</h2>
			<%  
				List<String> listY = ShowContacts.showContacts("Y");
				for(String string : listY) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
			<h2 id="Z">Z</h2>
			<%  
				List<String> listZ = ShowContacts.showContacts("Z");
				for(String string : listZ) {
					out.println("<p>" + string + "</p>");
					out.println("<a href=editContact.jsp class=button edit>Ändern</a>");
				}
			%>
		</div>
	</div> 
	
<body>

</body>
</html>