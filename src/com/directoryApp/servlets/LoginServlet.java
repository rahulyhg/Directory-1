package com.directoryApp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.directoryApp.DAO.UserDAO;
import com.directoryApp.DAO.UserDAOImpl;
import com.directoryApp.model.User;
import com.shank.jdbc.MyDBConnectionSource;
import com.shank.jdbc.MySQLDBConnectionSourceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(this.getClass().getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		//create a User on the basis of the values entered in the login page
		User user = new User();		
		user.setStaffNumber(Long.parseLong(request.getParameter("staffNo")));
		user.setPassword(request.getParameter("password"));
		
		logger.info("User is : "+user.getStaffNumber()+" , "+user.getPassword());
		
		//validate the user against the USERS database
		UserDAO userDAO = new UserDAOImpl(new MySQLDBConnectionSourceImpl());
		boolean validUser = userDAO.validateUser(user);
		
		//to release the connection
		try {
			userDAO.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info((new Boolean(validUser)).toString());
		
		//if user exists then dispatch to the AddOrSearch page
		//else display on the login page that the user staff no and password do not match, please re-enter
		if(validUser){
			request.setAttribute("User", user);
			request.setAttribute("validUser", validUser);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/AddOrSearch.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("validUser", validUser);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/Login.jsp");
			rd.forward(request, response);
		}
	}

}
