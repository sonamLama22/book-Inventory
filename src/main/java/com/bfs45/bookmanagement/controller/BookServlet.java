package com.bfs45.bookmanagement.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.bfs45.bookmanagement.model.Book;
import com.bfs45.bookmanagement.service.BookService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookServlet")
public class BookServlet  extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BookService service = new BookService();
		Set<Book> books = service.getBooks(); // get list of books
		String role = (String) req.getAttribute("role");
		RequestDispatcher dispatch = req.getRequestDispatcher("/bookDetails.jsp");
		req.setAttribute("role", role);
		req.setAttribute("bookDetails", books);
		dispatch.forward(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId = req.getParameter("id");
		String bookName = req.getParameter("bname");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		// update should be reflected in database.
	}

}
