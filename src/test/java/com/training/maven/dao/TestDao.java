package com.training.maven.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.training.maven.beans.User;

import static com.training.maven.dao.Dao.*;

public class TestDao {

//	@Test
//	public void testInsertUser() throws Exception{
//		
//		User user = new User();
//		
//		user.setUsername("new");
//		user.setPassword("lol");
//		
//		assertEquals(true, insertUser(user));
//	}
	
	@Test
	public void testGetUser() throws Exception{
		
		assertEquals("ummu", getUser("chuppu").getPassword());
		assertEquals(null, getUser("not present").getPassword());
	}
	
//	@Test
//	public void testDeleteUser() throws Exception{
//		
//		assertEquals(true, deleteUser("haha"));
//		assertEquals(false, deleteUser("not present"));
//	}
}
