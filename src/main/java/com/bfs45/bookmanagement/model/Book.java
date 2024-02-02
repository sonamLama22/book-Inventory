package com.bfs45.bookmanagement.model;

public class Book {
	
	private int bookId;
	private String bookName;
	private String description;
	private int price;
	
	public Book() {
		
	}
	
	public Book(int bookId, String bookName, String description, int price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.description = description;
		this.price = price;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
