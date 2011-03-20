package com.directoryApp.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.directoryApp.model.DirectoryEntry;

/**
 * Servlet implementation class UpdateContactServlet
 */
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// get the data from the request and put it in a CONTACT object
		//DirectoryEntry contact = new DirectoryEntry();
		//contact.setId(Long.parseLong(request.getParameter("ContactID")));
		//contact.setAddress(request.getParameter("Name"));
		
		// create a DAO for updating the contact
		
		// check if the updation is successful
		
		// try to close the connection
		
		// if the updation is successful, display an updation successful message
		// else display an updation failed message
		
	}

}
