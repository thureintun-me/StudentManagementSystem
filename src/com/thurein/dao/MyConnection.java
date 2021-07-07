package com.thurein.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	static Connection con = null;
	
	
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","admin");
		}catch (ClassNotFoundException e) {
			System.out.println("Driver Class NOt found");
		}catch (SQLException e) {
			System.out.println("database not found");
		}
		
		return con;
	}
}
