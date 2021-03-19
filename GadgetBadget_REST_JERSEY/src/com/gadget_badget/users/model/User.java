package com.gadget_badget.users.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int userID;
	private String userProfileName;
	private String bio;
	private String dob;
	private String email;
	
	private String username;
	private String password;
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserProfileName() {
		return userProfileName;
	}
	public void setUserProfileName(String userProfileName) {
		this.userProfileName = userProfileName;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userProfileName=" + userProfileName + ", bio=" + bio + ", dob=" + dob
				+ ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}