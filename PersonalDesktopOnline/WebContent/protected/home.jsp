<%@ page import = "pdo.settings.*"%>
<%@ page import = "pdo.utils.*"%>
<%
		Settings settings;
		if(session.getAttribute("SETTINGS") == null) {
			settings = DBConnectionManager.getSettingsForUser(request.getUserPrincipal().getName(), DBConnectionManager.getDBConnection());
			session.setAttribute("SETTINGS", settings);
		}
		else {
			settings = (Settings)session.getAttribute("SETTINGS");
		}		
%>
<!DOCTYPE html>
<html>
	<head>
		<title>PDO</title>
		<link rel="stylesheet" type="text/css" href="../styles/style.css"/>
	</head>
	<body>
		
		<div id="options">
			<a href="settings.jsp">
				<img class="option_icon" src="../images/gear.png" alt="Options">
			</a>
		</div>
		<div>
			<div id="notes" style=" visibility: <%= (settings.featureIsEnables("Notizen") ? "visible" : "hidden" ) %> ">
				<a href="NoteList.jsp">
					<img class="notes_img" src="../images/notizblock2.png" alt="Notizen">
				</a>
			</div>
			<div id="bleistift">
				<img id="bleistift_img" src="../images/bleistift.png" alt="Bleistift">
			</div>
			<div id="media" style="visibility: <%= (settings.featureIsEnables("Medien") ? "visible" : "hidden" ) %>">
				<a href="<%= settings.getURLForFeature("Medien") %>">
					<img class="media_img" src="../images/media.png" alt="Medien">
				</a>
			</div>
			<div id="calendar" style="visibility: <%= (settings.featureIsEnables("Kalender") ? "visible" : "hidden" ) %>" >
				<a href="<%= settings.getURLForFeature("Kalender") %>">
					<img class="calendar_img" src="../images/kalender5.png" alt="Kalender">
				</a>
			</div>
			<div id="news" style="visibility: <%= (settings.featureIsEnables("News") ? "visible" : "hidden" ) %>">
				<a href="<%= settings.getURLForFeature("News") %>">
					<img class="news_img" src="../images/news4.png" alt="Zeitung">
				</a>
			</div>
			
			<div id="contacts" style="visibility: <%= (settings.featureIsEnables("Kontakte") ? "visible" : "hidden" ) %>">
				<a href="contacts.jsp">
					<img class="contacts_img" src="../images/contacts3.png" alt="Kontakte">
				</a>
			</div>
			<div id="game" style="visibility: <%= (settings.featureIsEnables("Spiele") ? "visible" : "hidden" ) %>">
				<a href="<%= settings.getURLForFeature("Spiele") %>">
					<img class="game_img" src="../images/cube.png" alt="Spiele">
				</a>
			</div>
			<div id="documents" style="visibility: <%= (settings.featureIsEnables("Dokumente") ? "visible" : "hidden" ) %>">
				<a href="<%= settings.getURLForFeature("Dokumente") %>">
					<img class="documents_img" src="../images/documents2.png" alt="Dokumente">
				</a>
			</div>
			<div id="unterlage">
				<img class="unterlage_img" src="../images/unterlage.png" alt="Unterlage">
			</div>
			<div id="kaffee">
				<img class="kaffee_img" src="../images/kaffee.png" alt="Kaffee">
			</div>
		</div>
		<div id="logout"> 
			<a href="logout.jsp" > 
				<img class="logout_icon" src="../images/logout.png" alt="logout" />
			</a>
		</div>
	</body>
</html>