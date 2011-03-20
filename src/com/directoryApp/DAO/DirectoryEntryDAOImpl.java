/**
 * 
 */
package com.directoryApp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.directoryApp.model.DirectoryEntry;
import com.shank.jdbc.MyDBConnectionSource;
import com.shank.logger.DevLoggerFactory;


/**
 * @author admin
 *
 */
public class DirectoryEntryDAOImpl implements DirectoryEntryDAO {

	//private MyDBConnectionSource connectionSource;
	private Connection connection;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	/**
	 * 
	 */
	public DirectoryEntryDAOImpl(Connection connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
	}
	
	/**
	 * 
	 */
	public DirectoryEntryDAOImpl(MyDBConnectionSource connectionSource) {
		// TODO Auto-generated constructor stub
		this.connection = connectionSource.getConnection();
	}
	
	/* (non-Javadoc)
	 * @see directoryApp.DAO.DirectoryEntryDAO#delete(java.lang.Long)
	 */
	public boolean delete(Long pk) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see directoryApp.DAO.DirectoryEntryDAO#save(directoryApp.model.DirectoryEntry)
	 */
	public boolean save(DirectoryEntry directoryEntry) {
		// TODO Auto-generated method stub
		
		logger.info("saving directoryEntry");
		boolean isSaved=false;
		
		//get a statement for connection
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create query on basis of the directoryEntry
		boolean putComma = false; //use this variable to check where to put , in the query while appending
		StringBuffer query = new StringBuffer("insert into CONTACTS");
		StringBuffer colNames = new StringBuffer(" (");
		StringBuffer dataForColumns = new StringBuffer(" (");
		
		if(directoryEntry.getId() != null) {
			colNames.append(" ContactID=" + directoryEntry.getId());
			dataForColumns.append(" "+directoryEntry.getId());
			putComma = true;
		}
		if(directoryEntry.getName() != null & directoryEntry.getName() != ""){
			if(putComma){
				colNames.append(",");
				dataForColumns.append(",");
			}				
			colNames.append("Name");
			dataForColumns.append("'"+directoryEntry.getName()+"'");
			putComma = true;
		}			
		if(directoryEntry.getCellNumber() != null & directoryEntry.getCellNumber() != ""){
			if(putComma){
				colNames.append(",");
				dataForColumns.append(",");
			}
			colNames.append("CellNo");
			dataForColumns.append(directoryEntry.getCellNumber());
			putComma = true;
		}		
		if(directoryEntry.getLandlineNumber() != null & directoryEntry.getLandlineNumber() != ""){
			if(putComma){
				colNames.append(",");
				dataForColumns.append(",");
			}
			colNames.append("LandlineNo");
			dataForColumns.append("'"+directoryEntry.getLandlineNumber()+"'");
			putComma = true;
		}
		if(directoryEntry.getEmail() != null & directoryEntry.getEmail() != ""){
			if(putComma){
				colNames.append(",");
				dataForColumns.append(",");
			}
			colNames.append("Email");
			dataForColumns.append("'"+directoryEntry.getEmail()+"'");
			putComma = true;
		}
		if(directoryEntry.getCompany() != null & directoryEntry.getCompany() != ""){
			if(putComma){
				colNames.append(",");
				dataForColumns.append(",");
			}
			colNames.append("Company");
			dataForColumns.append("'"+directoryEntry.getCompany()+"'");
			putComma = true;
		}
		if(directoryEntry.getAddress() != null & directoryEntry.getAddress() != ""){
			if(putComma){
				colNames.append(",");
				dataForColumns.append(",");
			}
			colNames.append("Address");
			dataForColumns.append("'"+directoryEntry.getAddress()+"'");
		}
		
		colNames.append(")");
		query.append(colNames);
		query.append(" values ");
		dataForColumns.append(");");
		query.append(dataForColumns);
		
		logger.info("QUERY : "+query.toString());
		
		//using statement, executeUpdate a INSERT INTO TABLE 
		int savedRows = 0;
		if(stmt != null)
			try {
				savedRows = stmt.executeUpdate(new String(query));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		// if no exception occurs, set isSaved to true
		if(savedRows == 0)
			isSaved = false;
		if(savedRows == 1)
			isSaved = true;
		
		return isSaved;
	}

	/* (non-Javadoc)
	 * @see directoryApp.DAO.DirectoryEntryDAO#update(java.lang.Long, directoryApp.model.DirectoryEntry)
	 */
	public boolean update(Long pk, DirectoryEntry directoryEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<DirectoryEntry> search(DirectoryEntry directoryEntry) {
		// TODO Auto-generated method stub
		logger.info("inside search of DAO Impl...");
		
		//get a statement for connection
 		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// check which fields are null in the directoryEntry to be searched
		// On basis of the above check, create the search query
		boolean putAnd = false; //use this variable to check where to put and in the query while appending
		StringBuffer query = new StringBuffer("select * from CONTACTS where");
		if(directoryEntry.getId() != null) {
			query.append(" ContactID=" + directoryEntry.getId());
			putAnd = true;
		}
		if(directoryEntry.getName() != null & directoryEntry.getName() != ""){
			if(putAnd)
				query.append(" and");
			query.append(" Name like '%" + directoryEntry.getName() +"%'");
			putAnd = true;
		}			
		if(directoryEntry.getCellNumber() != null & directoryEntry.getCellNumber() != ""){
			if(putAnd)
				query.append(" and");
			query.append(" CellNo like '%" + directoryEntry.getCellNumber() +"%'");
			putAnd = true;
		}		
		if(directoryEntry.getLandlineNumber() != null & directoryEntry.getLandlineNumber() != ""){
			if(putAnd)
				query.append(" and");
			query.append(" LandlineNo like '%" + directoryEntry.getLandlineNumber() +"%'");
			putAnd = true;
		}
		if(directoryEntry.getEmail() != null & directoryEntry.getEmail() != ""){
			if(putAnd)
				query.append(" and");
			query.append(" Email like '%" + directoryEntry.getEmail() +"%'");
			putAnd = true;
		}
		if(directoryEntry.getCompany() != null & directoryEntry.getCompany() != ""){
			if(putAnd)
				query.append(" and");
			query.append(" Company like '%" + directoryEntry.getCompany() +"%'");
			putAnd = true;
		}
		if(directoryEntry.getAddress() != null & directoryEntry.getAddress() != ""){
			if(putAnd)
				query.append(" and");
			query.append(" Address like '%" + directoryEntry.getAddress() +"%'");
		}
		
		query.append(";");
		
		logger.info("QUERY : "+query.toString());
		
		//execute the query using the statement
		ResultSet rs = null;
		if(stmt != null){
			try {
				rs = stmt.executeQuery(query.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("Statement is null !!");
		}
				
		List<DirectoryEntry> resultList = new ArrayList<DirectoryEntry>();		
		//populate directory entry list from the result set
		//(a better way for the above list conversion would be to put the functionality in a separate method or class)
		if(rs != null){
			
			logger.info("Result Set is not null");
			
			try {
				rs.first();
				while(! rs.isAfterLast()){
					DirectoryEntry entry = new DirectoryEntry();
					entry.setId(rs.getLong("ContactID"));
					entry.setName(rs.getString("Name"));
					entry.setCompany(rs.getString("Company"));
					entry.setCellNumber(rs.getString("CellNo"));
					entry.setLandlineNumber(rs.getString("LandlineNo"));
					entry.setEmail(rs.getString("Email"));
					entry.setAddress(rs.getString("Address"));
					
					logger.info("Entry added to ResultList in search() : "+entry.getId());
					
					resultList.add(entry);
					rs.next();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		logger.info("returning result list to SearchContactServlet");
		
		return resultList;
	}

	public DirectoryEntry searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DirectoryEntry> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DirectoryEntry> searchByCompany(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DirectoryEntry> searchByItems(List<String> items) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DirectoryEntry> searchByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DirectoryEntry> searchByNos(List<String> nosList) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DirectoryEntry> searchByEmails(List<String> emailsList) {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
