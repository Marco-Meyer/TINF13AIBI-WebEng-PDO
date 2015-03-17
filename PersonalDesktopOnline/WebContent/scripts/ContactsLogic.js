
function tabSelectionChanged(tabIndex)
{
	allTabs = document.getElementsByName("tab");
	//allCategories = document.getElementsByClassName("settings-category");
	//displayCategory(allCategories, tabIndex)
	highLightTab(allTabs, tabIndex);
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

function addContact(){
	//bla
}

function showContacts(){
	//blubb
}