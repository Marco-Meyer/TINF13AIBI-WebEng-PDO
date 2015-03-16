<!DOCTYPE html>
<%@ page import = "pdo.settings.*"%>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="styles/SettingsStyle.css">
	<script type="text/javascript" src="scripts/SettingsLogic.js" ></script>
<title>PDO - Einstellungen</title>
</head>
<body onload="setupPage()">
	<%!Settings settings = Settings.CreateTestSettings(); %>
	<div id="settings-header">
		<span id="settings">Einstellungen</span>
		<a href="index.html" class="button delete">Abbrechen</a>
        <Button class="button save" onclick="saveChanges()">Speichern</Button>
    </div>
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
						<input type="radio" onclick="setDisplayType('Desktop')" name="view" value="picture" <%= (settings.getDisplayType() == DisplayType.Desktop ? "checked=\"checked\"" : "" ) %> ></input>
						<label>Schreibtisch</label>
					</li>
					<li>
						<input type="radio" onclick="setDisplayType('Galery')" name="view" value="galery" <%= (settings.getDisplayType() == DisplayType.Galery ? "checked=\"checked\"" : "" ) %>></input>
						<label>Galerie</label>
					</li>
				</ul>
				
			</div>
			<div id="quality-container" class="settings-container">
				<h3>Bildqualität</h3>
				<ul>
					<li>
						<input type="radio" onclick="setPictureQuality('High')" name="quality" value="high" <%= (settings.getPictureQuality() == PictureQuality.High ? "checked=\"checked\"" : "" ) %>></input>
						<label>Hoch</label>
					</li>
					<li>
						<input type="radio" onclick="setPictureQuality('Medium')" name="quality" value="medium" <%= (settings.getPictureQuality() == PictureQuality.Medium ? "checked=\"checked\"" : "" ) %>></input>
						<label>Mittel</label>
					</li>
					<li>
						<input type="radio" onclick="setPictureQuality('Low')" name="quality" value="low" <%= (settings.getPictureQuality() == PictureQuality.Low ? "checked=\"checked\"" : "" ) %>></input>
						<label>Niedrig</label>
					</li>
				</ul>
				
			</div>
			<div id="features-container" class="settings-container">
				<h3>Funktionen</h3>
				<ul>
					<% for(Feature feature : settings.getFeatures())
						{
							out.println(
							"<li><input  type='checkbox'" + (feature.isEnabled() ? "checked = 'checked'" : "") + "onclick=toggleFeature('" + feature.getName() + "')></input><label>" 
							+ feature.getName() + "</label></li>" );
						}
					%>
				</ul>
			</div>
		</div>
		<div class="settings-category">
			<div id="user-info-container" class="settings-container">
				<h3>Benutzerinformationen</h3>
				<div>
					<p>Benutzer: 		<%= settings.getUserInfo().getName() %></p>
					<p>E-Mail Adresse:	<%= settings.getUserInfo().geteMail() %></p>
				</div>	
			</div>
			<div id="change-mail-container" class="settings-container">
				<h3>E-Mail Adresse ändern</h3>
				<div>
					<p><label>Alte Adresse: </label><input type="text" style="margin-left: 162px"></input></p>
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