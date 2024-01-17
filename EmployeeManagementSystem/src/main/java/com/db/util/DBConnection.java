package com.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	
	private static DBConnection uniqueInstance;
	
	private DBConnection() {}
	
	public static DBConnection getInstance()
	{
		if(uniqueInstance==null) {
			uniqueInstance= new DBConnection();
				
		}
		return uniqueInstance;
	}
	
	public Connection createconnection() {
		
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/ems";
		
		String username = "root";
		
		String password = "root";
		
		System.out.println("In DBConnection.java class");
		
		try {
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			con = DriverManager.getConnection(url, username, password);
			
			System.out.println("Printing connection object "+ con);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
		
		
}
}
