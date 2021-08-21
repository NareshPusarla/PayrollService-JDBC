package com.bridgelabz.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	
	private static Connection connection = null;
	
	final String CONNECTION_URL = "jdbc:mysql://localhost:3306/payrollservice";

	final String USER_NAME = "root";

	final String PASSWORD = "root123";
	
	private DBConfig() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		
		return connection;
	}
}
