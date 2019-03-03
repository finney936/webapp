package com.training.maven.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.maven.beans.User;
import com.training.maven.dao.Dao;
import com.training.maven.beans.Address;
/**
 * Servlet implementation class MainServlet
 */

@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		getServletContext().setAttribute("web", "Website.com");
		
		if(request.getServletPath().equals("/"))
			request.getRequestDispatcher("View/index.jsp").forward(request, response);
		else if(request.getServletPath().equals("/home"))
			request.getRequestDispatcher("View/home.jsp").forward(request, response);
		else if(request.getServletPath().equals("/register"))
			request.getRequestDispatcher("View/register.jsp").forward(request, response);
		else if(request.getServletPath().equals("/registering")) {
			
			User user = new User();
			
			user.setUsername(request.getParameter("user"));
			user.setPassword(request.getParameter("pass"));
			
			Address address = new Address();
			
			user.setAddress(address);
			
			Dao.insertUser(user);
			
//			if(Dao.insertUser(user))
//				request.getRequestDispatcher("View/success.jsp").forward(request, response);
//			else
//				request.getRequestDispatcher("View/error.jsp").forward(request, response); 
		}
		else if(request.getServletPath().equals("/password"))
			request.getRequestDispatcher("View/password.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().println("Servlet doGet out working");
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("Servlet doPost out working");
	}

}
