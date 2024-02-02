package com.bfs45.bookmanagement.controller;

import java.io.IOException;

import com.bfs45.bookmanagement.model.User;
import com.bfs45.bookmanagement.service.UserRegistryService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		
		User user = new User(username, password, role); // create user object
		
		UserRegistryService service = new UserRegistryService(); // UserRegistryService object to access its method.
		String userId = service.userCreation(user); // pass the user object to userCreation() method.
		
		// forward the response to registrationSuccess page.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/registrationSuccess.jsp");
		req.setAttribute("userid", userId);
		dispatcher.forward(req, resp);
	}

}
