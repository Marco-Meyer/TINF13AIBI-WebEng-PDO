
var hostUrl = "http://localhost:8000/PersonalDesktopOnline/SettingsServlet"
var settings;

function setupPage()
{
	settings = new Settings();
	tabSelectionChanged(0);
}

function saveChanges() {
	try
	{
		var request = new XMLHttpRequest();
		console.log("request created");
		request.onreadystatechange = function () { console.log(request.readyState); }
				
		request.open("POST", hostUrl, true);	
		request.setRequestHeader("Content-type", "application/json");
		var data = JSON.stringify(settings);
		request.send(data);
	}
	catch(err)
	{
		console.log("error creating ajax-request: " + err.message);
	}
	
}

function toggleFeature(name) {
	for(i = 0; i < settings.features.length; i++) {
		var feature = settings.features[i];
		if(feature.name == name) {
			feature.enabled = !feature.enabled; 
		}
	}
}

function setUsername(username) {
	settings.userInfo.username = username;
}

function setEmail(eMail) {
	settings.userInfo.eMail = eMail
}

function setDisplayType(displayType) {
	settings.displayType = displayType;
}

function setPictureQuality(quality) {
	settings.pictureQuality = quality;
}


function tabSelectionChanged(tabIndex)
{
	allTabs = document.getElementsByName("tab");
	allCategories = document.getElementsByClassName("settings-category");
	displayCategory(allCategories, tabIndex)
	highLightTab(allTabs, tabIndex);
}
	
function displayCategory(categories, tabIndex) {
	for(i = 0; i < categories.length; i++) {
		if(i == tabIndex) {
			categories[i].style.display = "block";
		}
		else {				
			categories[i].style.display = "none";
		}
	}
}

function highLightTab(tabs, tabIndex) {
	for(i = 0; i < tabs.length; i++) {
		if(i == tabIndex) {
			tabs[i].className = "tabbar-element-selected";
		}
		else {				
			tabs[i].className = "tabbar-element";
		}
	}
}

function Settings() {
	this.displayType = "Desktop";
	this.pictureQuality = "High";
	this.userInfo = { username: "", eMail: ""};
	this.features = [ { name: "Kalender", enabled: true, url: "null" }, 
	                  { name: "Uhrzeit", enabled: false, url: "null" }, 
	                  { name: "Kontakte", enabled: false, url: "null" } ];
}
