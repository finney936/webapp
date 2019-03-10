package com.training.maven.dao;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.training.maven.beans.User;

@Component
public class Dao {

	private User user;
	private Configuration configuration;
	
	private String url;
	private String username;
	private String password;
	
	public Dao(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public User getUser() {
		return user;
	}

	@Autowired
	public void setUser(User user) {
		this.user = user;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	@Autowired
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	public boolean insertUser(User user) {

		String query = "insert into users (username, password) values ('" + user.getUsername() + "', '"
				+ user.getPassword() + "')";

		Connection connection = getConnection();

		int i = 0;

		try {

			Statement statement = connection.createStatement();

			i = statement.executeUpdate(query);

			// Releasing resources

			statement.close();
			connection.close();
		}

		catch (SQLException e) {

			e.printStackTrace();

			return false;

		}

		if (i > 0)
			return true;
		else
			return false;

	}

	/*
	 * public static boolean insertUser(User user) {
	 * 
	 * SessionFactory sessionFactory = configuration.buildSessionFactory();
	 * 
	 * Session session = sessionFactory.openSession();
	 * 
	 * Transaction transaction = session.beginTransaction();
	 * 
	 * session.save(user);
	 * 
	 * transaction.commit();
	 * 
	 * }
	 */

	public User getUser(String username) throws Exception {

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		User user = session.get(User.class, username);

		transaction.commit();

		if (user != null) {
			return user;
		} else
			return new User();
	}

	/*
	 * public static boolean deleteUser(String username) throws Exception{
	 * 
	 * String query = "DELETE FROM users WHERE username='"+ username +"'";
	 * 
	 * Connection connection = getConnection();
	 * 
	 * Statement statement = connection.createStatement();
	 * 
	 * int i = statement.executeUpdate(query);
	 * 
	 * // Releasing resources statement.close(); connection.close();
	 * 
	 * if(i > 0) return true; else return false; }
	 */

	@SuppressWarnings("unchecked")
	public ArrayList<User> userList() {

		ArrayList<User> list;

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from users");

		list = (ArrayList<User>) query.getResultList();

		transaction.commit();

		return list;
	}
}
