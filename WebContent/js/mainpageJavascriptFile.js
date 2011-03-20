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
function showInDetail(){
	alert("Show Contact Details");
}