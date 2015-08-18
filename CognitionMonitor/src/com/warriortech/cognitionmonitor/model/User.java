package com.warriortech.cognitionmonitor.model;

/**
 * 
 * @author ximinyan
 *
 */

public class User {
	public User(){
		
	}
	
	/**
	 * Initialize the class
	 * 
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param id
	 */
	public User(String firstName, String lastName, String password, String id){
		this.userId = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.password = password;
	}
	
	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * 
	 * @return password
	 */
	
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return userId
	 */
	public String getID() {
		return this.userId;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setID(String id) {
		this.userId = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * @return the mobileNum
	 */
	public String getMobileNum() {
		return mobileNum;
	}

	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String userId;
	private String email;
	private String birthDate;
	private String mobileNum;
	private int gender;
	
}
