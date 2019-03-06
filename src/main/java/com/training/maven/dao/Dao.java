package com.training.maven.dao;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.DriverManager;
import java.sql.SQLException;
=======
import java.util.ArrayList;
>>>>>>> servlet-based-config-web-xml

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.training.maven.beans.Address;
import com.training.maven.beans.User;

public class Dao {

<<<<<<< HEAD
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
=======
	static Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class);

	@Autowired
	static
	UserRepo repo;
	
	public static void insertUser(User user) {
		
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//		
//		Session session = sessionFactory.openSession();
//		
//		Transaction transaction = session.beginTransaction();
//		
//		session.save(user);
//		
//		transaction.commit();
		
		repo.save(user);
	
>>>>>>> servlet-based-config-web-xml
	}
	
	public static User getUser(String username) throws Exception{
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
<<<<<<< HEAD
		ResultSet set = statement.executeQuery(query);

		while(set.next()) {
			user.setUsername(set.getString("username"));
			user.setPassword(set.getString("password"));
		}

		// Releasing resources
		statement.close();
		connection.close();
=======
		User user = session.get(User.class, username);
		
		transaction.commit();
>>>>>>> servlet-based-config-web-xml
		
		if(user != null) {
			return user;
		}
		else
			return new User();
	}
	
/*	public static boolean deleteUser(String username) throws Exception{
		
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
	}*/
	
	public static ArrayList<User> userList(){
		
		ArrayList<User> list;
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from users");
		
		list = (ArrayList<User>)query.getResultList();
		
		return list;
	}
}
