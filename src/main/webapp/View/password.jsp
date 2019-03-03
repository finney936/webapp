<%@ page import="com.training.maven.dao.Dao" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password</title>
</head>
<body>
	
	<%= Dao.getUser((String)session.getAttribute("user")).getPassword() %>
	
	<footer><%= application.getAttribute("web") %></footer>

</body>
</html>