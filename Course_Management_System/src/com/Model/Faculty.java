package com.Model;

public class Faculty {
	private int facultyID;
	private String facultyName;
	private String address;
	private String mobile;
	private String email;
	private String userName;
	private String password;
	
	public Faculty() {
		super();
	}

	public Faculty(int facultyID, String facultyName, String address, String mobile, String email, String userName,
			String password) {
		super();
		this.facultyID = facultyID;
		this.facultyName = facultyName;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}


	public int getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "{facultyID :" + facultyID + ", facultyName :" + facultyName + ", address :" + address + ", mobile:"
				+ mobile + ", email :" + email + ", userName :" + userName + ", password :" + password + "]\n";
	}
	
}
