package com.training.maven.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.training.maven.beans.Address;
import com.training.maven.beans.Teacher;
import com.training.maven.beans.User;
import oracle.jdbc.driver.OracleDriver;

public class Dao {

	public static Configuration getConnection() {

		Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Teacher.class);
		
		return configuration;
		
	}

	public static void insertUser(User user) {
		
		Teacher teach1 = new Teacher();
		teach1.setName("Manjunath");
		teach1.setSchool("Bishop");
		teach1.setUser(user);
		
		Teacher teach3 = new Teacher();
		teach3.setName("Lokesh");
		teach3.setSchool("Bishop");
		
		User user2 = new User();
		
		user2.setUsername("finney");
		user2.setPassword("whatever");
		user2.setAddress(new Address());
		
		Teacher teach2 = new Teacher();
		teach2.setName("Pravin");
		teach2.setSchool("Bishop");
		
		user.getList().add(teach1);
		user.getList().add(teach2);
		user2.getList().add(teach3);
		
		Configuration configuration = getConnection();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(teach1);
		session.save(teach2);
		session.save(teach3);
		session.save(user);
		session.save(user2);
		
		transaction.commit();
	
	}
	
	public static User getUser(String username) throws Exception{
		
		Configuration configuration = getConnection();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		User user = session.get(User.class, username);
		
		transaction.commit();
		
		if(user != null) {
			return user;
		}
		else
			return new User();
	}
	
	/*public static boolean deleteUser(String username) throws Exception{
		
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
	
	public static ArrayList<User> userList(){
		
		ArrayList<User> list = new ArrayList<>();
		
		String query = "select * from users";
		
		Connection connection = getConnection();
		
		try {
			Statement statement = connection.createStatement();
			
			ResultSet set = statement.executeQuery(query);
			
			while(set.next()) {
				
				User user = new User();
				
				user.setUsername(set.getString(1));
				user.setPassword(set.getString(2));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}*/
}
