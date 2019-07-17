package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bean.Employee;
import com.revature.service.AuthenticationService;
import com.revature.service.Credentials;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * doGet: this method will handle all GET requests made to this servlet
	 */
	private AuthenticationService authService = new AuthenticationService();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// write a message to the response body with PrintWriter
		//resp.getWriter().write("hello from Login Servlet!");
		
		//serve the Login.html page as the response
		req.getRequestDispatcher("Login.html").forward(req, resp);
		/*
		 * RequestDispatcher is used to perform a 'foward' -passing request to another resource without clients awareness.
		 */
}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Credentials cred = new Credentials(req.getParameter("username"), req.getParameter("password"));
		Employee u = authService.authenticateEmployee(cred);
		if(u != null) {
			// resp.getWriter().write("Welcome, " + u.getFirstname() + u.getLastname());
			// redirect user to their profile page if authenticated.
			resp.sendRedirect("employee");
		}else{
			resp.sendRedirect("login");
	}
	}
}