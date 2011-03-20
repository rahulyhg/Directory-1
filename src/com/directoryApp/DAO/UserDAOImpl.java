/**
 * 
 */
package com.directoryApp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.directoryApp.model.User;
import com.shank.jdbc.MyDBConnectionSource;

/**
 * @author shank
 *
 */
public class UserDAOImpl implements UserDAO {
	
	private Connection connection;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	/**
	 * 
	 */
	public UserDAOImpl(Connection connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
	}
	
	/**
	 * 
	 */
	public UserDAOImpl(MyDBConnectionSource connectionSource) {
		// TODO Auto-generated constructor stub
		this.connection = connectionSource.getConnection();
	}
	
	/* (non-Javadoc)
	 * @see com.directoryApp.DAO.UserDAO#validateUser(com.directoryApp.model.User)
	 */
	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		logger.info("checking if user is valid");
		
		boolean validUser = false;
		
		//get a statement for connection
 		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//check if the given user exits in the Users table
		//if the user exists, then return true else return false
		String query = "select * from USERS where StaffNo ="+user.getStaffNumber()+" and Password ="+user.getPassword()+";" ;
		logger.info(query);
		ResultSet rs = null;
		if(stmt != null){
			try {
				rs = stmt.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("Statement is null !!");
		}
		
		if(rs != null){
			try {
				if(rs.next()){
					//this implies that there was atleat one record in the result set
					validUser = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		logger.info("user valid : "+validUser);
		
		return validUser;
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return this.connection;
	}

}
