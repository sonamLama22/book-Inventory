package com.bfs45.bookmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bfs45.bookmanagement.model.User;
import com.bfs45.bookmanagement.util.DBUtil;

public class UserDao {
	
	// save user info to db
	public String saveUser(User user) {
		
		Connection con = DBUtil.getConneciton();
		PreparedStatement ps = null;
		try {
			String query = "insert into user(user_id, user_name, password, role) values(?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			ps.execute();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				ps.close();
				DBUtil.closeConnection();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return user.getUserId();
		
	}
	
	// login validation
	public String validateUser(User user) {
		
		Connection con = DBUtil.getConneciton(); //create db connection
		PreparedStatement ps = null;
		String role = null;
		String query = "select role from user where user_name = ? and password = ?";
		try {
			ps = con.prepareStatement(query); // query compiled in sql
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ResultSet set = ps.executeQuery(); //returns role column from the table that matches username and password.
	
			if(set.next()) { //returns true if next row exists in the table, false otherwise.
				role = set.getString("role");
				
			}else {
				System.out.println("not found");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return role;
	}
}
