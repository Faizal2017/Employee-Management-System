package com.model;

public class Account_details {
	private String emp_id;
	private String account_no;
	private String bank;
	private String branch;
	
	public Account_details(){
		
	}
	public Account_details(String emp_id, String account_no, String bank, String branch) {
		super();
		this.emp_id = emp_id;
		this.account_no = account_no;
		this.bank = bank;
		this.branch = branch;
	}
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	

}
