package com.training.maven.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.maven.beans.User;
import com.training.maven.dao.Dao;

@Controller
public class MainController {

	@Autowired
	User user;
	@Autowired
	Dao dao;
	
	ModelAndView mv = new ModelAndView();
	
	@RequestMapping({"/","/index"})
	public ModelAndView index() {
		
		mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView home(@RequestParam("user")String username, @RequestParam("pass")String password) {
		
		mv.setViewName("home");
		mv.addObject("username", username);
		mv.addObject("password", password);
		mv.addObject("list", dao.userList());
		
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		
		mv.setViewName("register");
		
		return mv;
	}
	
	@RequestMapping("/registering")
	public ModelAndView registering(HttpServletRequest req, HttpServletResponse res) {
		
		user.setUsername(req.getParameter("user"));
		user.setPassword(req.getParameter("pass"));
		
		if(dao.insertUser(user))
			mv.setViewName("success");
		else
			mv.setViewName("fail");
		
		return mv;
	}
	
	@RequestMapping("/success")
	public ModelAndView success(HttpServletRequest req, HttpServletResponse res) {
		
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		
		mv.setViewName("success");
		mv.addObject("username", username);
		mv.addObject("password", password);
		
		return mv;
	}
	
	@RequestMapping("/password")
	public ModelAndView password(HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {
		
		mv.setViewName("password");
		mv.addObject("password", dao.getUser((String)session.getAttribute("user")).getPassword());
		
		return mv;
	}
}
