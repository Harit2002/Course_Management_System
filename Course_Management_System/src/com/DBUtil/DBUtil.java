package com.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	public static Connection provideConnection() {
		Connection conn = null;
		
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		 } catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 
		String url = "jdbc:mysql://localhost:3306/course_management";
		
		try {
		conn = DriverManager.getConnection(url,"root","Harit@274294");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
