<!DOCTYPE html>
<html>
	<head>
	  	<meta charset="UTF-8">
	  	<title>PDO - Sign Up/Login</title>
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet" type="text/css" />
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src="../scripts/apprise-v2.js"></script>
		<script src="../scripts/LogInScript.js"></script>
		<link rel="stylesheet" href="../styles/LogInStyle.css" />
		
	</head>
	<body>
		<div id="logmsk" style="display: block;">
		    <div id='close'>X</div>
		    <div id="userbox">
		        <h1 id="signup" style="background-color: rgb(118, 171, 219); background-position: initial initial; background-repeat: initial initial;">Sign up</h1>
		        <div id="sumsk" style="display: none;">Sending</div>
		        <form method="post" action="j_security_check">
			        <input name="j_username" id="name" placeholder="ID" style="opacity: 1; background-color: rgb(255, 255, 255); background-position: initial initial; background-repeat: initial initial;">
			        <input name="j_password" id="pass" type="password" placeholder="Password" style="opacity: 1; background-color: rgb(255, 255, 255); background-position: initial initial; background-repeat: initial initial;">
			        <p id="logint" style="opacity: 1;">Login as an existing user</p>
			        <p id="nameal" style="display: none; opacity: 1;">ID:</p>
			        <p id="passal" style="display: none; opacity: 1;">Password:</p>
			        <button id="signupb" style="opacity: 0.2; cursor: default;">Sign up</button>
		    	</form>
		    </div>
		</div>
	</body>
</html>