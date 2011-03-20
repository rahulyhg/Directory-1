/**
 * 
 */
package com.directoryApp.DAO;

import java.sql.Connection;

import com.directoryApp.model.User;

/**
 * @author shank
 *
 */
public interface UserDAO {
	public Connection getConnection();
	
	/*
	 * This method validates if the given user exists in the database
	 * and that the username / password pair matches the values in the database
	 */
	public boolean validateUser(User user);
}
