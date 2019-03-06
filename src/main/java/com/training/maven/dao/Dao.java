package com.training.maven.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.training.maven.beans.Address;
import com.training.maven.beans.User;

public class Dao {

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
	
	}
	
	public static User getUser(String username) throws Exception{
		
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
