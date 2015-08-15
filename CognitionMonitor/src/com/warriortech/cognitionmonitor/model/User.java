package com.warriortech.cognitionmonitor.model;

public class User {
	public User(){
		
	}
	
	public User(String firstName, String lastName, String password, String id){
		this.userId = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getID() {
		return this.userId;
	}
	public void setID(String id) {
		this.userId = id;
	}

	private String firstName;
	private String lastName;
	private String password;
	private String userId;
}
