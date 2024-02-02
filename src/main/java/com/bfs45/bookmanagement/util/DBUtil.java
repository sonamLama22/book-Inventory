package com.bfs45.bookmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection connection;
	private static final String url ="jdbc:mysql://localhost:3306/bfs45";
	private static final String username = "root";
	private static final String password = "root123";
	
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load Driver class
			connection = DriverManager.getConnection(url, username, password); //create connection
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}	
		}
	}
	

}
