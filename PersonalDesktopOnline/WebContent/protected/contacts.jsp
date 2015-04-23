<!DOCTYPE html>
<%					List<Contact> list0;
					if(session.getAttribute("0") == null) {
						list0 = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"0", DBConnectionManager.getDBConnection());
						session.setAttribute("0", list0);
					}
					else {
						list0 = (List<Contact>)session.getAttribute("0");
					}
					List<Contact> list1;
					if(session.getAttribute("1") == null) {
						list1 = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"1", DBConnectionManager.getDBConnection());
						session.setAttribute("1", list1);
					}
					else {
						list1 = (List<Contact>)session.getAttribute("1");
					}
					
					List<Contact> list2;
					if(session.getAttribute("2") == null) {
						list2 = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"2", DBConnectionManager.getDBConnection());
						session.setAttribute("2", list2);
					}
					else {
						list2 = (List<Contact>)session.getAttribute("2");
					}
					
					List<Contact> list3;
					if(session.getAttribute("3") == null) {
						list3 = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"3", DBConnectionManager.getDBConnection());
						session.setAttribute("3", list3);
					}
					else {
						list3 = (List<Contact>)session.getAttribute("3");
					}
					List<Contact> list4;
					if(session.getAttribute("4") == null) {
						list4 = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"4", DBConnectionManager.getDBConnection());
						session.setAttribute("4", list4);
					}
					else {
						list4 = (List<Contact>)session.getAttribute("4");
					}
					List<Contact> list5;
					if(session.getAttribute("5") == null) {
						list5 = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"5", DBConnectionManager.getDBConnection());
						session.setAttribute("5", list5);
					}
					else {
						list5 = (List<Contact>)session.getAttribute("5");
					}
					List<Contact> list6;
					if(session.getAttribute("6") == null) {
						list6 = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"6", DBConnectionManager.getDBConnection());
						session.setAttribute("6", list6);
					}
					else {
						list6 = (List<Contact>)session.getAttribute("6");
					}
					List<Contact> list7;
					if(session.getAttribute("7") == null) {
						list7 = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"77", DBConnectionManager.getDBConnection());
						session.setAttribute("7", list7);
					}
					else {
						list7 = (List<Contact>)session.getAttribute("7");
					}
					List<Contact> list8;
					if(session.getAttribute("8") == null) {
						list8 = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"8", DBConnectionManager.getDBConnection());
						session.setAttribute("8", list8);
					}
					else {
						list8 = (List<Contact>)session.getAttribute("8");
					}
					List<Contact> list9;
					if(session.getAttribute("9") == null) {
						list9 = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"9", DBConnectionManager.getDBConnection());
						session.setAttribute("9", list9);
					}
					else {
						list9 = (List<Contact>)session.getAttribute("9");
					}
					List<Contact> listA;
					if(session.getAttribute("A") == null) {
						listA = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"A", DBConnectionManager.getDBConnection());
						session.setAttribute("A", listA);
					}
					else {
						listA = (List<Contact>)session.getAttribute("A");
					}
					List<Contact> listB;
					if(session.getAttribute("B") == null) {
						listB = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"B", DBConnectionManager.getDBConnection());
						session.setAttribute("B", listB);
					}
					else {
						listB = (List<Contact>)session.getAttribute("B");
					}
					List<Contact> listC;
					if(session.getAttribute("C") == null) {
						listC = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"C", DBConnectionManager.getDBConnection());
						session.setAttribute("C", listC);
					}
					else {
						listC = (List<Contact>)session.getAttribute("C");
					}
					List<Contact> listD;
					if(session.getAttribute("D") == null) {
						listD = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"D", DBConnectionManager.getDBConnection());
						session.setAttribute("D", listD);
					}
					else {
						listD = (List<Contact>)session.getAttribute("D");
					}
					List<Contact> listE;
					if(session.getAttribute("E") == null) {
						listE = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"E", DBConnectionManager.getDBConnection());
						session.setAttribute("E", listE);
					}
					else {
						listE = (List<Contact>)session.getAttribute("E");
					}
					List<Contact> listF;
					if(session.getAttribute("F") == null) {
						listF = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"F", DBConnectionManager.getDBConnection());
						session.setAttribute("F", list0);
					}
					else {
						listF = (List<Contact>)session.getAttribute("F");
					}
					List<Contact> listG;
					if(session.getAttribute("G") == null) {
						listG = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"G", DBConnectionManager.getDBConnection());
						session.setAttribute("G", list0);
					}
					else {
						listG = (List<Contact>)session.getAttribute("G");
					}
					List<Contact> listH;
					if(session.getAttribute("H") == null) {
						listH = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"H", DBConnectionManager.getDBConnection());
						session.setAttribute("H", listH);
					}
					else {
						listH = (List<Contact>)session.getAttribute("H");
					}
					List<Contact> listI;
					if(session.getAttribute("I") == null) {
						listI = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"I", DBConnectionManager.getDBConnection());
						session.setAttribute("I", listI);
					}
					else {
						listI = (List<Contact>)session.getAttribute("I");
					}
					List<Contact> listJ;
					if(session.getAttribute("J") == null) {
						listJ = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"J", DBConnectionManager.getDBConnection());
						session.setAttribute("J", listJ);
					}
					else {
						listJ = (List<Contact>)session.getAttribute("J");
					}
					List<Contact> listK;
					if(session.getAttribute("K") == null) {
						listK = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"K", DBConnectionManager.getDBConnection());
						session.setAttribute("K", listK);
					}
					else {
						listK = (List<Contact>)session.getAttribute("K");
					}
					List<Contact> listL;
					if(session.getAttribute("L") == null) {
						listL = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"L", DBConnectionManager.getDBConnection());
						session.setAttribute("L", listL);
					}
					else {
						listL = (List<Contact>)session.getAttribute("L");
					}
					List<Contact> listM;
					if(session.getAttribute("M") == null) {
						listM = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"M", DBConnectionManager.getDBConnection());
						session.setAttribute("M", listM);
					}
					else {
						listM = (List<Contact>)session.getAttribute("M");
					}
					List<Contact> listN;
					if(session.getAttribute("N") == null) {
						listN = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"N", DBConnectionManager.getDBConnection());
						session.setAttribute("N", listN);
					}
					else {
						listN = (List<Contact>)session.getAttribute("N");
					}
					List<Contact> listO;
					if(session.getAttribute("O") == null) {
						listO = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"O", DBConnectionManager.getDBConnection());
						session.setAttribute("O", listO);
					}
					else {
						listO = (List<Contact>)session.getAttribute("O");
					}
					List<Contact> listP;
					if(session.getAttribute("P") == null) {
						listP = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"P", DBConnectionManager.getDBConnection());
						session.setAttribute("P", listP);
					}
					else {
						listP = (List<Contact>)session.getAttribute("P");
					}
					List<Contact> listQ;
					if(session.getAttribute("Q") == null) {
						listQ = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"Q", DBConnectionManager.getDBConnection());
						session.setAttribute("Q", listQ);
					}
					else {
						listQ = (List<Contact>)session.getAttribute("Q");
					}
					List<Contact> listR;
					if(session.getAttribute("R") == null) {
						listR = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"R", DBConnectionManager.getDBConnection());
						session.setAttribute("R", listR);
					}
					else {
						listR = (List<Contact>)session.getAttribute("R");
					}
					List<Contact> listS;
					if(session.getAttribute("S") == null) {
						listS = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"S", DBConnectionManager.getDBConnection());
						session.setAttribute("S", listS);
					}
					else {
						listS = (List<Contact>)session.getAttribute("S");
					}
					List<Contact> listT;
					if(session.getAttribute("T") == null) {
						listT = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"T", DBConnectionManager.getDBConnection());
						session.setAttribute("T", listT);
					}
					else {
						listT = (List<Contact>)session.getAttribute("T");
					}
					List<Contact> listU;
					if(session.getAttribute("U") == null) {
						listU = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"U", DBConnectionManager.getDBConnection());
						session.setAttribute("U", listU);
					}
					else {
						listU = (List<Contact>)session.getAttribute("U");
					}
					List<Contact> listV;
					if(session.getAttribute("V") == null) {
						listV = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"V", DBConnectionManager.getDBConnection());
						session.setAttribute("V", listV);
					}
					else {
						listV = (List<Contact>)session.getAttribute("V");
					}
					List<Contact> listW;
					if(session.getAttribute("W") == null) {
						listW = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"W", DBConnectionManager.getDBConnection());
						session.setAttribute("W", listW);
					}
					else {
						listW = (List<Contact>)session.getAttribute("W");
					}
					List<Contact> listX;
					if(session.getAttribute("X") == null) {
						listX = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"X", DBConnectionManager.getDBConnection());
						session.setAttribute("X", listX);
					}
					else {
						listX = (List<Contact>)session.getAttribute("X");
					}
					List<Contact> listY;
					if(session.getAttribute("Y") == null) {
						listY = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"Y", DBConnectionManager.getDBConnection());
						session.setAttribute("Y", listY);
					}
					else {
						listY = (List<Contact>)session.getAttribute("Y");
					}
					List<Contact> listZ;
					if(session.getAttribute("Z") == null) {
						listZ = DBConnectionManager.showContactsLetterForUser(request.getUserPrincipal().getName(),"Z", DBConnectionManager.getDBConnection());
						session.setAttribute("Z", listZ);
					}
					else {
						listZ = (List<Contact>)session.getAttribute("Z");
					}
%>
<html>
<%@ page import ="java.util.*"%>
<%@ page import ="pdo.contacts.Contact"%>
<%@ page import ="pdo.utils.*"%>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="../styles/ContactsStyle.css">
	<link rel="stylesheet" type="text/css" href="../styles/Scrollbar.css" />
	<script type="text/javascript" src="../scripts/ContactsLogic.js" ></script>
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
					
					for(Contact contact : list0) {
						contact.toString();
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}

				
					
					for(Contact contact : list1) {
						contact.toString();
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					for(Contact contact : list2) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					
					for(Contact contact : list3) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					
					for(Contact contact : list4) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					
					for(Contact contact : list5) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					
					for(Contact contact : list6) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					
					for(Contact contact : list7) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					
					for(Contact contact : list8) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
					
					
					for(Contact contact : list9) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="A">A</h2>
			<%
					
					for(Contact contact : listA) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="B">B</h2>
			<%
			
					for(Contact contact : listB) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="C">C</h2>
			<%
			
					for(Contact contact : listC) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="D">D</h2>
			<%
			
					for(Contact contact : listD) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="E">E</h2>
			<%
			
					for(Contact contact : listE) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="F">F</h2>
			<%
			
					for(Contact contact : listF) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="G">G</h2>
			<%
			
					for(Contact contact : listG) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="H">H</h2>
			<%

					for(Contact contact : listH) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="I">I</h2>
			<%
			
					for(Contact contact : listI) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="J">J</h2>
			<%
			
					for(Contact contact : listJ) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="K">K</h2>
			<%
			
					for(Contact contact : listK) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="L">L</h2>
			<%
			
					for(Contact contact : listL) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="M">M</h2>
			<%
			
					for(Contact contact : listM) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="N">N</h2>
			<%
			
					for(Contact contact : listN) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="O">O</h2>
			<%
			
					for(Contact contact : listO) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="P">P</h2>
			<%
			
					for(Contact contact : listP) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="Q">Q</h2>
			<%
			
					for(Contact contact : listQ) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="R">R</h2>
			<%
			
					for(Contact contact : listR) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="S">S</h2>
			<%
			
					for(Contact contact : listS) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="T">T</h2>
			<%
			
					for(Contact contact : listT) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="U">U</h2>
			<%
			
					for(Contact contact : listU) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="V">V</h2>
			<%
			
					for(Contact contact : listV) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="W">W</h2>
			<%
			
					for(Contact contact : listW) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="X">X</h2>
			<%
			
					for(Contact contact : listX) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="Y">Y</h2>
			<%
			
					for(Contact contact : listY) {
						contact.editContact(contact, out);
						contact.deleteContact(contact, out);
					}
			%>
			<h2 id="Z">Z</h2>
			<%
			
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