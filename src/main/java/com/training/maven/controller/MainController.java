package com.training.maven.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res) {
		
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("View/home.jsp");
		mv.addObject("username", username);
		mv.addObject("password", password);
		
		return mv;
	}
}
