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
		settings.getUserInfo().setName(request.getUserPrincipal().getName());
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">	
	<link rel="stylesheet" type="text/css" href="../styles/SettingsStyle.css" />
	<link rel="stylesheet" type="text/css" href="../styles/apprise-v2.css"/>
	<script type="text/javascript" src="../scripts/jquery-1.11.2.js" ></script>
	<script type="text/javascript" src="../scripts/apprise-v2.js" ></script>	
	<script type="text/javascript" src="../scripts/SettingsLogic.js" ></script>
	<title>PDO - Einstellungen</title>
</head>
<body onload="setupPage()">
	<div id="settings-header">
		<span id="settings">Einstellungen</span>
		<a href="home.jsp" class="button delete">Abbrechen</a>
        <button class="button save" onclick="saveChanges()">Speichern</button>
    </div>
	<div id="settings-tabbar-container" >
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(0)"><p class="tab-label">Anzeige</p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(1)"><p class="tab-label">Benutzer</p></div>
		<div name="tab" class="tabbar-element" onclick="tabSelectionChanged(2)"><p class="tab-label">Erweitert</p></div>
	</div>
	<div id="settings-categories-container" >
		<div class="settings-category">
			<div id="view-container" class="settings-container">
				<h3>Ansicht</h3>
				<ul>
					<li>
						<input class="redondo" type="radio" onclick="setDisplayType('Desktop')" name="view" value="Desktop" <%= (settings.getDisplayType() == DisplayType.Desktop ? "checked=\"checked\"" : "" ) %> ></input>
						<label>Schreibtisch</label>
					</li>
					<li>
						<input class="redondo" type="radio" onclick="setDisplayType('Galery')" name="view" value="Galery" <%= (settings.getDisplayType() == DisplayType.Galery ? "checked=\"checked\"" : "" ) %>></input>
						<label>Galerie</label>
					</li>
				</ul>			
			</div>
			<div id="quality-container" class="settings-container">
				<h3>Bildqualität</h3>
				<ul>
					<li>
						<input class="redondo" type="radio" onclick="setPictureQuality('High')" name="quality" value="High" <%= (settings.getPictureQuality() == PictureQuality.High ? "checked=\"checked\"" : "" ) %>></input>
						<label>Hoch</label>
					</li>
					<li>
						<input class="redondo" type="radio" onclick="setPictureQuality('Medium')" name="quality" value="Medium" <%= (settings.getPictureQuality() == PictureQuality.Medium ? "checked=\"checked\"" : "" ) %>></input>
						<label>Mittel</label>
					</li>
					<li>
						<input class="redondo" type="radio" onclick="setPictureQuality('Low')" name="quality" value="Low" <%= (settings.getPictureQuality() == PictureQuality.Low ? "checked=\"checked\"" : "" ) %>></input>
						<label>Niedrig</label>
					</li>
				</ul>
				
			</div>
			<div id="features-container" class="settings-container">
				<h3>Funktionen</h3>
				<table>
					
					<% for(Feature feature : settings.getFeatures())
						{
							out.println(
							  "<tr class='features-table'>"
							+ "<td><input  type='checkbox'" + (feature.isEnabled() ? "checked = 'checked'" : "") + "onclick=toggleFeature('" + feature.getName() + "')/>"
							+ "<label class='feature-name'>" +feature.getName() + "</label></td>"
							+ "<td><a href='" + feature.getUrl() + "' id='url-label-" + feature.getName() + "' class='url-label'>" + feature.getUrl() + "</a></td>"
							+ "<td><input type='button' value='Url bearbeiten' class='button-general' onclick=\"createEditBox('Neue Url: ', 'url-label-" + feature.getName() + "')\" /></td>"
							+ "</tr>");
						}
					%>
				</table>
			</div>
		</div>
		<div class="settings-category">
			<div id="user-info-container" class="settings-container">
				<h3>Benutzerinformationen</h3>
				<div id="user-name"><span>Benutzer: </span><%= settings.getUserInfo().getName() %></div>
			</div>
			<div id="change-mail-container" class="settings-container">
				<h3>E-Mail Adresse ändern</h3>
				<div>
					<div><label>Neue Adresse</label></div><div><input type="text""></input></div>
					<div><label>Neue Adresse bestätigen</label></div><div><input type="text"></input></div>
					<button class="button-general" style="margin-top:5pt;">E-Mail Adresse ändern</button>
				</div>	
			</div>
			
			<div id="password-container" class="settings-container">
				<h3>Passwort ändern</h3>
				<div>
						<div><label>Altes Passwort</label></div><div><input type="password"></input></div>
						<div><label>Neues Passwort</label></div><div><input type="password"></input></div>
						<div><label>Neues Passwort bestätigen</label></div><div><input type="password"></input></div>
						<button class="button-general" style="margin-top:5pt;">Passwort ändern</button>
				</div>
			</div>
		</div>
		<div class="settings-category"></div>
	</div>
</body>
</html>