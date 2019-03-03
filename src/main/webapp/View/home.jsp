<%@page import="javax.naming.Context, com.training.maven.dao.Dao, java.util.ArrayList, com.training.maven.beans.User,
javax.servlet.http.Cookie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<% session.setAttribute("user", request.getParameter("user")); %>

	Hi <%= request.getParameter("user") %><br>
	
	<% 
	
	String user = null;
	
	Cookie[] cookies = request.getCookies();
	
	for(Cookie c: cookies){
		
		if(c.getName().equals("user")){
			
			user = c.getValue();
		}
		else{
			
			Cookie cookie = new Cookie("user", request.getParameter("user"));
			
			response.addCookie(cookie);
		}
			
	}
	   
	%>

	From cookie: <%= user %>
	
	<%
	
	ArrayList<User> list = Dao.userList();
	
	for(int i = 0; i < list.size(); i++){
		
		out.println(list.get(i).getUsername() + "<br>");
	}
	
	%>
	
	<br><form action="password"><button type="submit">Get Password</button></form>
	
	<footer><%= application.getAttribute("web") %></footer>
</body>
</html>