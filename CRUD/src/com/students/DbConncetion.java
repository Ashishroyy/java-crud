package com.students;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConncetion {
	static Connection con;
	
	public static Connection createCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/crud","root","root");
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}
	

}
