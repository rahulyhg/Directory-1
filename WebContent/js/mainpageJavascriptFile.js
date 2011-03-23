function doYourWork(){
	//validate fields
	var validationSuccessful = true;
	//validate Name
	//validate Company
	//validate Cell Number
	//validate Landline Number
	//validate Email
	//validate Address
	
	//if validation is successful then set the action for the form
	if(validationSuccessful == true){
		if(document.pressed=="ADD CONTACT"){
			//alert("inside ADD CONTACT()");
			//alert(document.addOrSearchForm);
			document.addOrSearchForm.action="/DIRECTORY/addContact.do";
			return true;
		}
		else if(document.pressed=="SEARCH CONTACT"){
			document.addOrSearchForm.action="/DIRECTORY/searchContact.do";
			//alert("inside SEARCH CONTACT()");
			return true;
		}
	}
	
	//alert("action set to : "+document.addOrSearchForm.action);

	return false;
}	

function setResultsVisible(ResultList){
	
	if(ResultList != null)
		document.getElementById("SearchResults").style.display = 'block';
	else
		document.getElementById("SearchResults").style.display = 'none';
	
}

/*
 * This function is used to show the details of the selected contact
 */
function showInDetail(rowNumber){
	//alert("testing");
	
	alert("Show Contact Details"+" row number is "+rowNumber);
	
	var contactDetails="";
	
	var content=document.getElementsByTagName('td');
	
	//alert(content);
	
	//for(i=0 ; i<content.length ; i++)
		//alert("column No. "+i+" "+content[i].innerHTML);
	
	var start = 21+(rowNumber-1)*7;	//since there are 7 columns in each row and the starting index of the results list is 21
	var end = start+6 ;	//only till the address field
	
	//alert(start+" "+end);
	
	//variable to find the row name so that it can be appended to the alert
	var colNum = 0;
	for(c=start ; c < end ; c++) {
		contactDetails = contactDetails + addColumnName(colNum) + " : ";
		
		contactDetails = contactDetails + content[c].innerHTML;
		
		colNum++;
		//alert(contactDetails);
	}
	
	alert(contactDetails);
	
}

/*
This function returns the column name according to the column number provided as the argument
*/
function addColumnName(colNum){
	
	if(colNum == 0)
		return "Name";
	if(colNum == 1)
		return "Company";
	if(colNum == 2)
		return "Cell Number";
	if(colNum == 3)
		return "Landline Number";
	if(colNum == 4)
		return "Email";
	if(colNum == 5)
		return "Address";
}