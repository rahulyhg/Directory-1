package com.directoryApp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.directoryApp.DAO.DirectoryEntryDAO;
import com.directoryApp.DAO.DirectoryEntryDAOImpl;
import com.directoryApp.model.DirectoryEntry;
import com.shank.jdbc.MyDBConnectionSource;
import com.shank.jdbc.MySQLDBConnectionSourceImpl;
import com.shank.logger.DevLoggerFactory;


/**
 * Servlet implementation class AddContactServlet
 */
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = DevLoggerFactory.getLoggerForTheClass(this.getClass().getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("inside doGet");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig sconfig = getServletConfig();		
		ServletContext sc = sconfig.getServletContext();
		
		// create a new DirectoryEntry which shall be populated on basis of the fields entere on the jsp
		DirectoryEntry directoryEntry = new DirectoryEntry();
		logger.info("DirectoryEntry object created "+directoryEntry);
		
		// get the data from request and put it in the DirectoryEntry
		directoryEntry.setName(request.getParameter("name"));
		directoryEntry.setCompany(request.getParameter("company"));
		directoryEntry.setCellNumber(request.getParameter("cellNumber"));
		directoryEntry.setLandlineNumber(request.getParameter("landlineNumber"));
		directoryEntry.setEmail(request.getParameter("email"));
		directoryEntry.setAddress(request.getParameter("address"));
		
		//log these values to the logger
		//logger.info(name+" "+company+" "+cellNumber+" "+email+" "+landlineNumber+" "+address);
		
		// get an instance of DAO impl for DirectoryEntries
		DirectoryEntryDAO directoryEntryDAO = new DirectoryEntryDAOImpl(new MySQLDBConnectionSourceImpl());
		logger.info("DirectoryEntryDAO created inside AddContactServlet : "+directoryEntryDAO);
		
		// save the directoryEntry using the DirectoryEntryDAOImpl
		logger.info("calling save() of DAO");
		boolean isSaved = directoryEntryDAO.save(directoryEntry);
		
		//to release the connection
		try {
			directoryEntryDAO.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set the "isSaved" attribute in request to true so as to signal that the contact has been successfully saved
		request.setAttribute("isSaved", isSaved);
		
		//remove the "resultPage" attribute of the request object which shall be there in case we are on the search results page
		if(request.getAttribute("resultPage") != null)
			request.setAttribute("resultPage", null);
						
		if(isSaved){
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/AddOrSearch.jsp");
			rd.forward(request, response);
		} else {
			logger.info("Unable to save the directoryEntry");
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/failure.jsp");
			rd.forward(request, response);
		}
		
	}

}