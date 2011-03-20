/**
 * 
 */
package com.shank.logger;

import java.util.logging.Logger;

/**
 * @author shank
 * This class returns a Logger with logging facility to a central file
 */
public class DevLoggerFactory {
	
	//private static File logFile;
	private static Logger logger = Logger.getLogger("DevLoggerFactory");
	
	/**
	 * This method returns the logger for a particular class
	 * This method takes care of the exception handling so that the calling class need not worry about it !
	 * @param className
	 * @return
	 */
	public static Logger getLoggerForTheClass(String className){
		Logger loggerToBeReturned = Logger.getLogger(className);
		
		logger.info("logger created for class : "+className);
		
		try {
			// TODO find a way to create files same as the class name and use them for logging
			
			//attach the appropriate handlers to the logger
			
			//FileHandler fileHandler = new FileHandler(logFile.getAbsolutePath(), true);
			//fileHandler.setFormatter(new SimpleFormatter());
			//loggerToBeReturned.addHandler(fileHandler);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			
			//loggerToBeReturned.severe(e.toString());
			
			e.printStackTrace();
		}
		
		return loggerToBeReturned;
	}
	
}
