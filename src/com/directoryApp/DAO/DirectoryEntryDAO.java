/**
 * 
 */
package com.directoryApp.DAO;

import java.sql.Connection;
import java.util.List;
import com.directoryApp.model.DirectoryEntry;


/**
 * @author BHEL
 *
 */
public interface DirectoryEntryDAO {
	public Connection getConnection();
	public void setConnection(Connection connection);
	
	public boolean save(DirectoryEntry directoryEntry);
	
	public boolean update(Long pk, DirectoryEntry directoryEntry);
	
	public boolean delete(Long pk);
	
	public List<DirectoryEntry> search(DirectoryEntry directoryEntry);
	public DirectoryEntry searchById(Long id);
	public List<DirectoryEntry> searchByName(String name);
	public List<DirectoryEntry> searchByCompany(String company);
	public List<DirectoryEntry> searchByItems(List<String> items);
	public List<DirectoryEntry> searchByAddress(String address);
	//public List<DirectoryEntry> searchByLandlineNumber(String landlineNumber);
	//public List<DirectoryEntry> searchByCellNumber(String cellNumber);
	//public List<DirectoryEntry> searchByEmail(String email);
	public List<DirectoryEntry> searchByNos(List<String> nosList);
	public List<DirectoryEntry> searchByEmails(List<String> emailsList);
	
}
