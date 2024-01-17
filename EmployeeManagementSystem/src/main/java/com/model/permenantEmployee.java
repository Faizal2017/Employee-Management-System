package com.model;

public class permenantEmployee extends employee{
	
	//Declaration of variable
	private double salary;
	
	
	//Default constructor
	public permenantEmployee() {};
    
	
	//overloaded constructor
	public permenantEmployee(String id, String dob, String name, String gender, String address, String phone, String email,
			String department, String position, String date, String photo ,double salary) {
		
		super(id, dob, name, gender, address, phone, email, department, position, date, photo);
		this.setSalary(salary);
		
		
	}
	//Getters and Setters for variable
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public double calcsal() {
		// TODO Auto-generated method stub
		return salary;
	}
     
	
}
