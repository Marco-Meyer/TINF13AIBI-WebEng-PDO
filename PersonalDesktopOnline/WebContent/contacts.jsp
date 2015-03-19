<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="styles/ContactsStyle.css">
	<script type="text/javascript" src="scripts/ContactsLogic.js" ></script>
<title>PDO - Kontakte</title>
</head>
	<div id="contacts-header">
		<span id="contacts">Kontakte</span>
		<a href="newContact.html" class="button add">Hinzufügen</a> 
		<!--  Button class="button save" onclick="saveChanges()">Speichern</Button> -->
    </div>
	<div id="contacts-tabbar-container" >

	<!-- border-right: 1px solid #A5A5A5; -->
	
	
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
			<h2 id="A">A</h2>
			<h2 id="B">B</h2>
			<h2 id="C">C</h2>
			<h2 id="D">D</h2>
			<h2 id="E">E</h2>
			<h2 id="F">F</h2>
			<h2 id="G">G</h2>
			<h2 id="H">H</h2>
			<h2 id="I">I</h2>
			<h2 id="J">J</h2>
			<h2 id="K">K</h2>
			<h2 id="L">L</h2>
			<h2 id="M">M</h2>
			<h2 id="N">N</h2>
			<h2 id="O">O</h2>
			<h2 id="P">P</h2>
			<h2 id="Q">Q</h2>
			<h2 id="R">R</h2>
			<h2 id="S">S</h2>
			<h2 id="T">T</h2>
			<h2 id="U">U</h2>
			<h2 id="V">V</h2>
			<h2 id="W">W</h2>
			<h2 id="X">X</h2>
			<h2 id="Y">Y</h2>
			<h2 id="Z">Z</h2>
		</div>
	</div> 
	
<body>

</body>
</html>