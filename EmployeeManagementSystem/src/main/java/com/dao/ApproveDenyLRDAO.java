package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.util.DBConnection;

public class ApproveDenyLRDAO {

	
	//Static method
	public static String Approve(String reqid) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			// create Connection object to connect database
			DBConnection DBcon =DBConnection.getInstance();
			
			conn = DBcon.createconnection();
			stmt = conn.createStatement();	
			String Query = "UPDATE leaverequest SET status='Approved' WHERE ReqID ='" + reqid + "'"; // Query to execute

			int i = stmt.executeUpdate(Query);
			
			// if success
			if (i!=0)
				return "SUCCESS";
			
			
		}
		catch (SQLException e) { // If Any Sql Exception occur
			
			e.printStackTrace();
			
		}
		
		return "Oops.. Something went wrong there..!" ;  // if unsuccess
		
		
	}
	
	//Static method
	public static String Deny(String reqid) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// create Connection object to connect database
			DBConnection DBcon =DBConnection.getInstance();
			
			conn = DBcon.createconnection();
			stmt = conn.createStatement();	
			String Query = "UPDATE leaverequest SET status='Denied' WHERE ReqID ='" + reqid + "'"; // Query to execute

			int i = stmt.executeUpdate(Query);
			
			// if success
			if (i!=0)
				return "SUCCESS"; 
			
			
		}
		catch (SQLException e) { // If Any Sql Exception occur
			
			e.printStackTrace();
			
		}
		
		return "Oops.. Something went wrong there..!" ;  // if unsuccess
		
		
		
		
	}
}
