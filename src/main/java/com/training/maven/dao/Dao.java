package com.training.maven.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.training.maven.beans.User;

public class Dao {

	@Autowired
	static
	User user;
	
	public static Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "system";
		String password = "Blackshadow936";
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}

	public static boolean insertUser(User user) {
		
		String query = "insert into users (username, password) values ('" + user.getUsername() + "', '" + user.getPassword() + "')";
		
		Connection connection = getConnection();
		
		int i = 0;
		try {
			Statement statement = connection.createStatement();
			
			i = statement.executeUpdate(query);
			// Releasing resources
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		if(i > 0)
			return true;
		else
			return false;
	}
	
	public static User getUser(String username) throws Exception{
		
		String query = "select * from users where username = '" + username + "'";
		
		Connection connection = getConnection();
		
		Statement statement = connection.createStatement();
		
		ResultSet set = statement.executeQuery(query);

		while(set.next()) {
			user.setUsername(set.getString("username"));
			user.setPassword(set.getString("password"));
		}

		// Releasing resources
		statement.close();
		connection.close();
		
		return user;
	}
	
	public static boolean deleteUser(String username) throws Exception{
		
		String query = "DELETE FROM users WHERE username='"+ username +"'";
		
		Connection connection = getConnection();
		
		Statement statement = connection.createStatement();
		
		int i = statement.executeUpdate(query);

		// Releasing resources
		statement.close();
		connection.close();
		
		if(i > 0)
			return true;
		else
			return false;
	}
}
