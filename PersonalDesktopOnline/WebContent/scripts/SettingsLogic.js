
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
		settings.update();
		var request = new XMLHttpRequest();
		request.onreadystatechange = function () {}		
		request.open("POST", hostUrl, true);	
		request.setRequestHeader("Content-type", "application/json");
		request.send(JSON.stringify(settings));
	}
	catch(err)
	{
		console.log("error creating ajax-request: " + err.message);
	}
	
}

function createEditBox(text, id) {
	Apprise(text, {input: true, targetId: id});
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
	
	this.displayType = "";
	this.pictureQuality = "";
	this.userInfo = { username: "", eMail: ""};
	this.features = [];
	
	
	this.getUrls = function () {
		var urls = document.getElementsByClassName("url-label");
		for(i = 0; i < urls.length; i++) {
			this.features[i].url = urls[i].innerHTML;
		}
	}
	this.getMail = function () {
		this.userInfo.eMail = document.getElementById("user-mail").innerHTML;
	}
	this.getUserName = function () {
		this.userInfo.username = document.getElementById("user-name").innerHTML;
	}
	
	this.getDisplayType = function() {
		var views = document.getElementsByName("view");
		for(i = 0; i < views.length; i++) {
			if(views[i].checked){
				this.displayType = views[i].value;
			}
		}
	}
	
	this.getPictureQuality = function() {
		var qualities = document.getElementsByName("quality");
		for(i = 0; i < qualities.length; i++) {
			if(qualities[i].checked){
				this.pictureQuality = qualities[i].value;
			}
		}
	}
	
	this.getUserInfo = function() {
		this.getMail();
		this.getUserName();
	}
	
	this.getFeatures = function () {
		var features = [];
		var featureElements = document.getElementsByClassName("features-table");
		for(i = 0; i < featureElements.length; i++) {
			var element = featureElements[i];
			var newFeature = { name: "", enabled: false, url: "" };
			newFeature.enabled = element.childNodes[0].firstChild.checked;
			newFeature.name = element.childNodes[0].childNodes[1].innerHTML;
			newFeature.url = element.childNodes[1].firstChild.innerHTML;
			features.push(newFeature);
		}
		this.features = features;
	}
	
	this.update = function() {
		this.getUserInfo();
		this.getUserName();
		this.getDisplayType();
		this.getPictureQuality();
		this.getFeatures();
	}
}
