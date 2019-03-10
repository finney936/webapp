<%@ page import="com.training.maven.dao.Dao" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password</title>
</head>
<body>
	
	<%= (String)session.getAttribute("password") %>
	
	<footer>Website.com</footer>

</body>
</html>