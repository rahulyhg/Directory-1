/**
 * 
 */
package com.directoryApp.listeners;

import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.shank.logger.DevLoggerFactory;

/**
 * @author admin
 *
 */
public class DirectoryAppServletContextListener implements
		ServletContextListener {

	private Logger contextLogger;
	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		try {
			java.sql.DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
		ServletContext sc = event.getServletContext();
		
		//now get a logger for this class from DevLoggerFactory
		contextLogger = DevLoggerFactory.getLoggerForTheClass(this.getClass().getName());
		
		//database related init parameters
				
		//log admin emails
		contextLogger.info("AdminEmail1 initialized to "+sc.getInitParameter("adminEmail1"));
		contextLogger.info("AdminEmail2 initialized to "+sc.getInitParameter("adminEmail2"));
		
		/*
		for(Handler h : contextLogger.getHandlers())
			h.close();
		*/
	}

}
