package com.directoryApp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
import com.shank.jdbc.MySQLDBConnectionSourceImpl;

/**
 * Servlet implementation class AddOrSearchServlet
 */
public class SearchContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(this.getClass().getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContactServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		logger.info("DirectoryEntryDAO created inside SearchContactServlet : "+directoryEntryDAO);
		
		// search the directoryEntry using the DirectoryEntryDAOImpl
		logger.info("calling search() of DAO");
		List<DirectoryEntry> results = directoryEntryDAO.search(directoryEntry);
		
		logger.info("Number of search results is : "+results.size());
		
		//store this results list in the request object to be forwarded to the view
		request.setAttribute("ResultList", results);
		
		// set a particular attribute in the request object so that the AddOrSearch.jsp
		// can use it to decide to display the hidden results table
		request.setAttribute("resultPage", new Object());
		
		//to release the connection
		try {
			directoryEntryDAO.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/AddOrSearch.jsp");
		rd.forward(request, response);
		
	}

}
