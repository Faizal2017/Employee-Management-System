package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.util.DBConnection;
import com.model.Account_details;

public class AccountDAO {

	public String AddAccount(Account_details account) {
		
		String employeeID = account.getEmp_id();
		String accountNO = account.getAccount_no();
		String bank= account.getBank();
		String branch= account.getBranch();
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			
			String query = "insert into accountdetails values ( ? , ? , ? , ? )";
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, employeeID);
			stmt.setString(2, accountNO);
			stmt.setString(3, bank);
			stmt.setString(4, branch);
			
			int i = stmt.executeUpdate();
			
			if (i!=0)
				return "SUCCESS";
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong there..!" ;
	}
	
	public static ResultSet Acc_Details() {
		  Connection con = null;
		  ResultSet rs = null;
		  Statement stmt = null;
		  
			try {
				
				DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();
				stmt = con.createStatement();	
				String query = "select empID, accountNO, bank, branch from accountdetails ";
				
				rs = stmt.executeQuery(query);
				
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			return rs;
		}
	
	public String Delete_acc(String EmpID, String accNo) {
		  Connection con = null;
		  Statement stmt = null;
		  
		  try {
		       
			  DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();

		        stmt = con.createStatement();

		        int i = stmt.executeUpdate("DELETE FROM accountdetails WHERE EmpId='" + EmpID+"' and AccountNo='" +accNo+"'");
				
				if (i!=0)
					return "SUCCESS";

		        con.close();
		    }
		    catch(Exception e){
		        e.printStackTrace();
		    }
		  
		  return "Oops.. Something went wrong there..!" ;
		}
	
	public ResultSet Get_Details(String EmpID, String accNo) {
		  Connection con = null;
		  ResultSet rs = null;
		  Statement stmt = null;
		  
		  try {
		       
			  DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();

		    	stmt = con.createStatement();

		        
				
		        String query = "select * FROM accountdetails WHERE EmpId='" + EmpID+"' and AccountNo='" +accNo+"' ";
				
				 rs= stmt.executeQuery(query);
				
				

		    }
		    catch(Exception e){
		        e.printStackTrace();
		    }
		  
		  return rs;
		 
		  
		}
	
	
	
	public String UpdateAccount(Account_details account, String OldAcc) {
		
		String employeeID = account.getEmp_id();
		String accountNO = account.getAccount_no();
		String bank= account.getBank();
		String branch= account.getBranch();
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			
			DBConnection DBcon =DBConnection.getInstance();
			
			con = DBcon.createconnection();
			
			String query = "Update accountdetails set AccountNo = ?, bank= ?, branch= ? where EmpId= ? and AccountNo= ?";
			
			stmt = con.prepareStatement(query);
			
			stmt.setString(1, accountNO);
			stmt.setString(2, bank);
			stmt.setString(3, branch);
			stmt.setString(4, employeeID);
			stmt.setString(5, OldAcc);
			
			int i = stmt.executeUpdate();
			
			if (i!=0)
				return "SUCCESS";
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong there..!" ;
	}
	
	public ResultSet PayAcc(String EmpID) {
		  Connection con = null;
		  ResultSet rs = null;
		  Statement stmt = null;
		  
		  try {
		       
			  DBConnection DBcon =DBConnection.getInstance();
				
				con = DBcon.createconnection();

		    	stmt = con.createStatement();

		        
				
		        String query = "select concat(AccountNo,', ', Bank, ', ', Branch) FROM accountdetails WHERE EmpId='" + EmpID+"'";
				
				 rs= stmt.executeQuery(query);
				
				

		    }
		    catch(Exception e){
		        e.printStackTrace();
		    }
		  
		  return rs;
		 
		  
		}
	
}