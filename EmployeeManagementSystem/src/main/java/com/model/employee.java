package com.model;

public abstract class employee {
	
	
	//Declaration of variables
	
	private String id;
	private String dob;
	private String name;
	private String gender;
	private String address;
	private String phone;
	private String email;
	private String department;
	private String position;
	private String date;
	private String photo ;
	
	//Default constructor
	
	public employee() {};
	
	//overloaded constructor
	public employee(String id, String dob, String name, String gender, String address, String phone, String email,
			String department, String position, String date, String photo) {
		super();
		this.id = id;
		this.dob=dob;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.department = department;
		this.position = position;
		this.date = date;
		this.photo = photo;
	}
	
	//Abstract method to calculate salary
	public abstract  double calcsal();
	
	
	//Getters and Setters for variables
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
	

}
