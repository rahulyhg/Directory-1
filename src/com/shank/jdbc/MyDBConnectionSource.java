/**
 * 
 */
package com.shank.jdbc;

import java.sql.Connection;

/**
 * @author shank
 *
 */
public interface MyDBConnectionSource {
	public Connection getConnection(String driver, String url, String userName, String password);
	public Connection getConnection();
}
