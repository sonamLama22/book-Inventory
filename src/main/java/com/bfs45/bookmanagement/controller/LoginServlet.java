package com.bfs45.bookmanagement.controller;
// controller handles requests from client.
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
		String password = req.getParameter("password"); // get password
		String userId = req.getParameter("userid");
		
		System.out.println("userId "+ userId);
		System.out.println("password "+ password);
		
		User user = new User(userId, password);
		LoginValidationService result= new LoginValidationService();
		
		// .getWriter() returns a PrintWriter object that can be used to send character data to the client.
		PrintWriter pw = resp.getWriter(); // use HttpServletResponse reference 'resp'.
		
		try {
			String role = result.isValid(user);
//			System.out.println("loginServlet role -> "+role);
		if(role == null){
			resp.setContentType("text/html");
			pw.println("<h3 style='color:red; text-align:center'> "
					+ "Please enter proper details</h3>"); // prints data in the browser
			RequestDispatcher dispatch = req.getRequestDispatcher("/Login.jsp");
			dispatch.include(req, resp); // includes Login.jsp page as output.
		}
		if("user".equals(role)){
			RequestDispatcher dispatcher = req.getRequestDispatcher("/bookServlet");
			req.setAttribute("role", role);
			dispatcher.forward(req, resp);
		}
		if("admin".equals(role)) {
			RequestDispatcher dispstcher = req.getRequestDispatcher("/bookServlet");
			req.setAttribute("role", role);
			dispstcher.forward(req, resp);
		}} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
