<!DOCTYPE html>
<html>
<%@ page import ="java.util.*"%>
<%@ page import ="pdo.contacts.Contact"%>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="styles/ContactsStyle.css">
	<link rel="stylesheet" type="text/css" href="styles/Scrollbar.css" />
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
				List<Contact> list0 = Contact.showContacts("0");
					for(Contact contact : list0) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
				
					List<Contact> list1 = Contact.showContacts("1");
					for(Contact contact : list1) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					List<Contact> list2 = Contact.showContacts("2");
					for(Contact contact : list2) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					List<Contact> list3 = Contact.showContacts("3");
					for(Contact contact : list3) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					List<Contact> list4 = Contact.showContacts("4");
					for(Contact contact : list4) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					List<Contact> list5 = Contact.showContacts("5");
					for(Contact contact : list5) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					List<Contact> list6 = Contact.showContacts("6");
					for(Contact contact : list6) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					List<Contact> list7 = Contact.showContacts("7");
					for(Contact contact : list7) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					List<Contact> list8 = Contact.showContacts("8");
					for(Contact contact : list8) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					List<Contact> list9 = Contact.showContacts("9");
					for(Contact contact : list9) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="A">A</h2>
			<%
				List<Contact> listA = Contact.showContacts("A");
					for(Contact contact : listA) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="B">B</h2>
			<%
				List<Contact> listB = Contact.showContacts("B");
					for(Contact contact : listB) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="C">C</h2>
			<%
				List<Contact> listC = Contact.showContacts("C");
					for(Contact contact : listC) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="D">D</h2>
			<%
				List<Contact> listD = Contact.showContacts("D");
					for(Contact contact : listD) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="E">E</h2>
			<%
				List<Contact> listE = Contact.showContacts("E");
					for(Contact contact : listE) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="F">F</h2>
			<%
				List<Contact> listF = Contact.showContacts("F");
					for(Contact contact : listF) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="G">G</h2>
			<%
				List<Contact> listG = Contact.showContacts("G");
					for(Contact contact : listG) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="H">H</h2>
			<%
				List<Contact> listH = Contact.showContacts("H");
					for(Contact contact : listH) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="I">I</h2>
			<%
				List<Contact> listI = Contact.showContacts("I");
					for(Contact contact : listI) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="J">J</h2>
			<%
				List<Contact> listJ = Contact.showContacts("J");
					for(Contact contact : listJ) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="K">K</h2>
			<%
				List<Contact> listK = Contact.showContacts("K");
					for(Contact contact : listK) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="L">L</h2>
			<%
				List<Contact> listL = Contact.showContacts("L");
					for(Contact contact : listL) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="M">M</h2>
			<%
				List<Contact> listM = Contact.showContacts("M");
					for(Contact contact : listM) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="N">N</h2>
			<%
				List<Contact> listN = Contact.showContacts("N");
					for(Contact contact : listN) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="O">O</h2>
			<%
				List<Contact> listO = Contact.showContacts("O");
					for(Contact contact : listO) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="P">P</h2>
			<%
				List<Contact> listP = Contact.showContacts("P");
					for(Contact contact : listP) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="Q">Q</h2>
			<%
				List<Contact> listQ = Contact.showContacts("Q");
					for(Contact contact : listQ) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="R">R</h2>
			<%
				List<Contact> listR = Contact.showContacts("R");
					for(Contact contact : listR) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="S">S</h2>
			<%
				List<Contact> listS = Contact.showContacts("S");
					for(Contact contact : listS) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="T">T</h2>
			<%
				List<Contact> listT = Contact.showContacts("T");
					for(Contact contact : listT) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="U">U</h2>
			<%
				List<Contact> listU = Contact.showContacts("U");
					for(Contact contact : listU) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="V">V</h2>
			<%
				List<Contact> listV = Contact.showContacts("V");
					for(Contact contact : listV) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="W">W</h2>
			<%
				List<Contact> listW = Contact.showContacts("W");
					for(Contact contact : listW) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="X">X</h2>
			<%
				List<Contact> listX = Contact.showContacts("X");
					for(Contact contact : listX) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="Y">Y</h2>
			<%
				List<Contact> listY = Contact.showContacts("Y");
					for(Contact contact : listY) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="Z">Z</h2>
			<%
				List<Contact> listZ = Contact.showContacts("Z");
					for(Contact contact : listZ) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
		</div>
	</div> 
	
<body>

</body>
</html>