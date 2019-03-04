package com.training.maven.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.training.maven.beans.User;

@Configuration
@ComponentScan("com.training.maven.*")
public class AppConfig {

	@Bean
	public InternalResourceViewResolver viewResolverJSP() {
		
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		
		vr.setPrefix("/View/");
		vr.setSuffix(".jsp");
		
		return vr;
	}
	
	@Bean(name = "user")
	@Scope(scopeName = "prototype")
	public User user1() {

		User user = new User();
		
		user.setUsername("User");
		user.setPassword("Password");
	
		return user;
	}
	
	@Bean(name = "user2")
	@Scope(scopeName = "prototype")
	public User user2() {

		User user = new User();
		
		user.setUsername("useru");
		user.setPassword("passu");
	
		return user;
	}
}
