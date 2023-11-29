package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	private static Connection conn;

	public static Connection getConn() {
		try {
			if (conn == null) {

				Class.forName("com.mysql.cj.jdbc.Driver");

				// create the connection
				String user = "root";
				String password = "Perfect@123";

//				jdbc:mysql://localhost:3306/mydb

				String url = "jdbc:mysql://localhost:3306/online_portal";
//				
				try {
					conn = DriverManager.getConnection(url, user, password);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
