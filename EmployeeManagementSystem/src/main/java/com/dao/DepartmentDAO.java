package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.util.DBConnection;
import com.model.DepartmentDetails;

public class DepartmentDAO {
	
	public String AddDepartment(DepartmentDetails department) {
		
		String departmentID = department.getDepartmentID();
		String departmentName = department.getDepartmentName();
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			// create Connection object to connect database
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			
			String query = "insert into department values ( ? , ? )";
			
			stmt = con.prepareStatement(query);
			// set values through prepared statement
			stmt.setString(1, departmentID);
			stmt.setString(2, departmentName);
			
			int i = stmt.executeUpdate();
			
			// if success
			if (i!=0)
				return "SUCCESS";
			
		}
		catch (SQLException e) { // If Any Sql Exception occur
			
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong there..!" ; // if unsuccess
	}
	
	//Static method
	public static ResultSet Dep_Details() {
		  Connection con = null;
		  ResultSet rs = null;
		  Statement stmt = null;
		  
			try {
				// create Connection object to connect database
				DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();
				stmt = con.createStatement();	
				String query = "select * from department ";  // Query to execute
				
				rs = stmt.executeQuery(query);
				
			}
			catch (SQLException e) { // If Any Sql Exception occur
				
				e.printStackTrace(); 
			}
			return rs; // return ResultSet  
		}
	
	//Static method
	public String Delete_dep(String DepId) {
		  Connection con = null;
		  Statement stmt = null;
		  
		  try {
			// create Connection object to connect database
			  DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();

		        stmt = con.createStatement();

		        int i = stmt.executeUpdate("DELETE FROM department WHERE DepId='" + DepId+"'");
				
				if (i!=0)
					return "SUCCESS";

		        con.close();
		    }
		    catch(Exception e){
		        e.printStackTrace();
		    }
		  
		  return "Oops.. Something went wrong there..!" ;
		}
	
	public String UpdateDepartment(DepartmentDetails department) {
		
		String depID = department.getDepartmentID();
		String depName = department.getDepartmentName();
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			
			String query = "update department set DepName= ?  where DepId= ? ";
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, depName);
			stmt.setString(2, depID);
			
			int i = stmt.executeUpdate();
			
			if (i!=0)
				return "SUCCESS";
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong there..!" ;
	}
}
