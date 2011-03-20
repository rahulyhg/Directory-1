/**
 * 
 */
package com.directoryApp.model;

import java.util.List;

/**
 * @author BHEL
 * 
 * This class encapsulates a particular contact
 * 
 * It contains the composite data from CONTACTS, ALTERNATE_NOS, ALTERNATE_EMAILS, ASSOCIATED_ITEMS tables
 * 
 */
public class DirectoryEntry implements Entry{
	private Long id; //This id is the ContactID in the CONTACTS table
	private String name;
	private String company;
	private String address;
	//the items list is populated on the basis of the ASSOCIATED_ITEMS table and ASSOCIATED_NON_STD_ITEMS
	//private List<String> items;
	private String cellNumber;
	private String landlineNumber;
	private String email;
	//the items list is populated on the basis of the ALTERNATE_NOS table
	//private List<String> alternateNos;
	//the items list is populated on the basis of the ALTERNATE_EMAILS table
	//private List<String> alternateEmails;
	
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(String number) {
		this.cellNumber = number;
	}
	public String getLandlineNumber() {
		return landlineNumber;
	}
	public void setLandlineNumber(String number) {
		this.landlineNumber = number;
	}
	
}
