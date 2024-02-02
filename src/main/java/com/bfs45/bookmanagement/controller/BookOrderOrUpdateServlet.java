package com.bfs45.bookmanagement.controller;

import java.io.IOException;

import com.bfs45.bookmanagement.model.Book;
import com.bfs45.bookmanagement.service.BookService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookOrderOrUpdateServlet")
public class BookOrderOrUpdateServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] s = req.getParameterValues("listofbookid");
		String buttonType = req.getParameter("buttonid");
		for(int i=0; i<s.length; i++) {
			System.out.println(s[i]);
		}

		if ("order".equals(buttonType)) {

			// logic to order ->
			// create table in db --> bookorder(id, orderid, bookid)

		} else if ("update".equals(buttonType)) {

			if (s.length == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("/bookUpdate.jsp");
				BookService service = new BookService();
				Book book = service.getBooks(Integer.valueOf(s[0]));
				System.out.println("bookOrderUpdate: "+ s[0]);
				req.setAttribute("book", book);
				rd.forward(req, resp);
			}

		}

	}
}
