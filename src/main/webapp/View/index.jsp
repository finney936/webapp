<html>
<head>

	<link rel="stylesheet" href="../WEB-INF/CSS/styles-1.css">

</head>

<body>

	<div class="mid">
		<h2 class="sign">SIGN IN</h2>
	
		<form action="home">
		
			<label>Username:</label> <input type="text" name="user"></input><br><br>
			<label>Password:</label> <input type="text" name="pass"></input><br><br>
			<button type="submit">Sign In</button>
			
		</form>
		
		<form action="register">
			<button type="submit">Register</button>
		</form>
	</div>

<footer><%= application.getAttribute("web") %></footer>
</body>
</html>
