package com.training.maven.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.maven.beans.User;
import com.training.maven.dao.Dao;
/**
 * Servlet implementation class MainServlet
 */
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
			
			if(Dao.insertUser(user))
				request.getRequestDispatcher("View/success.jsp").forward(request, response);
			else
				request.getRequestDispatcher("View/fail.jsp").forward(request, response);
		}
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
