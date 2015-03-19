<!DOCTYPE html>
<%@ page import = "pdo.settings.*"%>
<html>
<head>
	<meta charset="ISO-8859-1">	
	<link rel="stylesheet" type="text/css" href="styles/SettingsStyle.css" />
	<link rel="stylesheet" type="text/css" href="styles/apprise-v2.css"/>
	<script type="text/javascript" src="scripts/jquery-1.11.2.js" ></script>
	<script type="text/javascript" src="scripts/apprise-v2.js" ></script>	
	<script type="text/javascript" src="scripts/SettingsLogic.js" ></script>
	<title>PDO - Einstellungen</title>
</head>
<body onload="setupPage()">
	<%!Settings settings = Settings.CreateTestSettings(); %>
	<div id="settings-header">
		<span id="settings">Einstellungen</span>
		<a href="index.html" class="button delete">Abbrechen</a>
        <a href="index.html" class="button save" onclick="saveChanges()">Speichern</a>
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
						<input type="radio" onclick="setDisplayType('Desktop')" name="view" value="Desktop" <%= (settings.getDisplayType() == DisplayType.Desktop ? "checked=\"checked\"" : "" ) %> ></input>
						<label>Schreibtisch</label>
					</li>
					<li>
						<input type="radio" onclick="setDisplayType('Galery')" name="view" value="Galery" <%= (settings.getDisplayType() == DisplayType.Galery ? "checked=\"checked\"" : "" ) %>></input>
						<label>Galerie</label>
					</li>
				</ul>			
			</div>
			<div id="quality-container" class="settings-container">
				<h3>Bildqualität</h3>
				<ul>
					<li>
						<input type="radio" onclick="setPictureQuality('High')" name="quality" value="High" <%= (settings.getPictureQuality() == PictureQuality.High ? "checked=\"checked\"" : "" ) %>></input>
						<label>Hoch</label>
					</li>
					<li>
						<input type="radio" onclick="setPictureQuality('Medium')" name="quality" value="Medium" <%= (settings.getPictureQuality() == PictureQuality.Medium ? "checked=\"checked\"" : "" ) %>></input>
						<label>Mittel</label>
					</li>
					<li>
						<input type="radio" onclick="setPictureQuality('Low')" name="quality" value="Low" <%= (settings.getPictureQuality() == PictureQuality.Low ? "checked=\"checked\"" : "" ) %>></input>
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
							+ "<td><input type='button' value='Url bearbeiten' class='editurl' onclick=\"createEditBox('Neue Url: ', 'url-label-" + feature.getName() + "')\" /></td>"
							+ "</tr>");
						}
					%>
				</table>
			</div>
		</div>
		<div class="settings-category">
			<div id="user-info-container" class="settings-container">
				<h3>Benutzerinformationen</h3>
				<table>
					<tr><td><p>Benutzer: </p></td><td><p id="user-name"><%= settings.getUserInfo().getName() %></p></td></tr>
					<tr><td><p>E-Mail Adresse:</p></td><td><p id="user-mail" ><%= settings.getUserInfo().geteMail() %></p></td></tr>
					
				</table>	
			</div>
			<div id="change-mail-container" class="settings-container">
				<h3>E-Mail Adresse ändern</h3>
				<div>
					<p><label>Neue Adresse: </label><input type="text" style="margin-left: 149px;"></input></p>
					<p><label>Neue Adresse bestätigen: </label><input type="text" style="margin-left: 59px;"></input></p>
					<button >E-Mail Adresse ändern</button>
				</div>	
			</div>
			
			<div id="password-container" class="settings-container">
				<h3>Passwort ändern</h3>
				<div>
						<p><label>Altes Passwort: </label><input type="password" style="margin-left: 144px;"></input></p>
						<p><label>Neues Passwort: </label><input type="password" style="margin-left: 131px;;"></input></p>
						<p><label>Neues Passwort bestätigen: </label><input type="password" style="margin-left: 41px;"></input></p>
						<button>Passwort ändern</button>
				</div>
			</div>
		</div>
		<div class="settings-category"></div>
	</div>
</body>
</html>