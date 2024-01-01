package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	public static Connection getConnector() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/fsd57";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","root");
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
