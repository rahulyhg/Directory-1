/*
 * This method contains the validations to be done on the login page before submission
 * The actual validations done on each field are kept in a separate javascript file
 */
function validateAndSubmit(form){

	//alert("1");
	
	var action = "/DIRECTORY/login.do";
	var validationSuccessful = true;
	var msg = "";
	
	//validate staffNo
	//validate password
	//if any validation fails, display alerts and dont submit the form
	
	//alert(form.staffNo.value);
	if(form.staffNo.value == null | form.staffNo.value == ""){
		//staffNo empty
		//alert("2");
		msg = msg+"\nSTAFF NO : cannot be empty";
		validationSuccessful = false;
	}else if(validateDigitInput(form.staffNo.value) != true){
		//staffNo not empty but staffNo validation failed
		//alert("3");
		msg = msg+"STAFF NO : only numeric values are allowed";
		//alert(msg);
		validationSuccessful = false;
	}
	//alert(form.password.value);
	if(form.password.value == null | form.password.value == ""){
		//password empty
		msg = msg+"\nPASSWORD : cannot be empty";
		//alert(msg);
		validationSuccessful = false;
	}
	if(validationSuccessful == true){
		document.getElementById("loginForm").action = action;
		return true;
	}else{
		//alert(msg);
		return false;
	}	
}

/*
the below method displays the incorrect user/password statement based on the value of validUser
*/
function setUserValidateFailedVisible(validUser){

	//alert(validUser);
	
	document.getElementById("userValidateFailed").style.display = 'none';
	
	if (validUser == null) {
		//alert("5");
		document.getElementById("userValidateFailed").style.display = 'block';
	}else if (validUser == ""){
		//alert("2");
		document.getElementById("userValidateFailed").style.display = 'none';
	}else if(validUser == false || validUser == "false"){
		//alert("3");
		document.getElementById("userValidateFailed").style.display = 'block';
	}else if (validUser == true || validUser == "true") {
		//alert("4");
		document.getElementById("userValidateFailed").style.display = 'none';
	}	

}