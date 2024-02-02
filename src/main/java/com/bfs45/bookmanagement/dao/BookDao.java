package com.bfs45.bookmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.bfs45.bookmanagement.model.Book;
import com.bfs45.bookmanagement.util.DBUtil;

public class BookDao {
	
	// return list of books
	public Set<Book> getBooks() throws SQLException {
		
		Connection con = DBUtil.getConnection();
		String query = "select * from book";
		PreparedStatement ps = con.prepareStatement(query);
	
		ResultSet set = ps.executeQuery();
		HashSet<Book> books = new HashSet<Book>();
		while(set.next()) {
			Book book = new Book();
			book.setBookId(set.getInt(1));
			book.setBookName(set.getString(2));
			book.setDescription(set.getString(3));
			book.setPrice(set.getInt(4));
			books.add(book);
		}
		return books;
	}
	

	// returns a single book based on its ID.
	public Book getBook(int bookId) throws SQLException{
		
		Connection con=DBUtil.getConnection();
		
		PreparedStatement ps=con.prepareStatement("SELECT * FROM BOOK where book_id=?");
		ps.setInt(1, bookId);
		ResultSet rs=ps.executeQuery();
		Book book=new Book();
		while(rs.next()) {
			
			book.setBookId(rs.getInt(1));
			book.setBookName(rs.getString(2));
			book.setDescription(rs.getString(3));
			book.setPrice(rs.getInt(4));
			
		}
		
		return book;
	}

	
}
