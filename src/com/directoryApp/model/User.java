/**
 * 
 */
package com.directoryApp.model;

/**
 * @author shank
 * 
 * This class encapsulates the user that is currently logged in the system and 
 * who is modifying / searching records
 *
 */
public class User {
	
	private long staffNumber;
	private String password;
	
	public long getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(long staffNumber) {
		this.staffNumber = staffNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
