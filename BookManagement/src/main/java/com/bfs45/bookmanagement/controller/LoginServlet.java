package com.bfs45.bookmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.bfs45.bookmanagement.model.User;
import com.bfs45.bookmanagement.service.LoginValidationService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//access data using 'req' object of HttpServletRequest interface.
		String username = req.getParameter("username"); // get username
		String password = req.getParameter("password"); // get password
		
		System.out.println("username "+ username);
		System.out.println("password "+ password);
		
		User user = new User(username, password);
		LoginValidationService result= new LoginValidationService();
		
		// .getWriter() returns a PrintWriter object that can be used to send character data to the client.
		PrintWriter pw = resp.getWriter(); // use HttpServletResponse reference 'resp'.
		String role = result.isValid(user);
		
		if(role == null) {
			resp.setContentType("text/html");
			pw.println("<h3 style='color:red; text-align:center'> "
					+ "You are not a valid user/admin.</h3>"); // prints data in the browser
			RequestDispatcher dispatch = req.getRequestDispatcher("/Login.jsp");
			dispatch.include(req, resp); // includes Login.jsp page as output.
		}else {
			pw.println("hi, "+ username + ". You are a valid "+ role);
		}
		
	}

}
