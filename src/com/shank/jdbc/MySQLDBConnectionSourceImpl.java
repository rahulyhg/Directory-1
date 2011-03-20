/**
 * This class is utility class for getting a connection to a MySQL DB
 */
package com.shank.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.shank.logger.DevLoggerFactory;

/**
 * @author shank
 *
 */
public class MySQLDBConnectionSourceImpl implements MyDBConnectionSource{
	
	private Logger logger = DevLoggerFactory.getLoggerForTheClass(this.getClass().getName());
	
	public MySQLDBConnectionSourceImpl(){
		super();
	}
	
	public Connection getConnection(){
		//create connection to 
		//jdbc:mysql://localhost:3306/TrialDatabase
		//root
		//password
		
		Connection con = null;
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/DirectoryDB";
		String user = "root";
		String password = "password";
		
	
		try {
			Class.forName(driver);
			
			if (logger != null) {
				logger.info("driver class initialized");
			}else{
				System.out.println("driver class initialized");
			}
			
			con = DriverManager.getConnection(url, user, password);
			
			if (logger != null) {
				logger.info("connection created !!");
			}else{
				System.out.println("connection created !!");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}

	public Connection getConnection(String driver, String url, String userName,
			String password) {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try {
			Class.forName(driver);
			
			if (logger != null) {
				logger.info("driver class initialized");
			}else{
				System.out.println("driver class initialized");
			}
			
			con = DriverManager.getConnection(url, userName, password);
			
			if (logger != null) {
				logger.info("connection created !!");
			}else{
				System.out.println("connection created !!");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
