package com.training.maven.beans;

<<<<<<< HEAD
import org.springframework.beans.factory.InitializingBean;

public class User{
=======

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="users")
public class User {
>>>>>>> servlet-based-config-web-xml

	@Id
	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

}