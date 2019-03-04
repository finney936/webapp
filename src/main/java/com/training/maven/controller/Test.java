package com.training.maven.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.maven.beans.Teacher;
import com.training.maven.beans.User;

public class Test {

	public static void main(String args[]) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		User user1 = (User) context.getBean("user");
		
		System.out.println(user1.getUsername());
		
		user1.setUsername("orhit");

		User user2 = (User) context.getBean("user2");
		
		System.out.println(user2.getUsername());
		
		Teacher teacher = (Teacher)context.getBean("teacher");
		
		System.out.println(teacher.getUser().getUsername() + "Teacher");
		
	}
}
