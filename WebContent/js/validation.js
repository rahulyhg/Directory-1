/*
	The below method is used for validation of an input fields that accepts the following characters
	a-z A-Z 0-9
*/
function validateStringInput(value){
	
	var stringInputRegExp = /^[\w]+$/;
	
	//alert(stringInputRegExp.test()==true);
	
	if(stringInputRegExp.test(value)==true){
		//alert("2");
		return true;
	}else{
		//alert("3");
		return false;
	}
	
}

/*
	This method validates that a field contains only digits
*/
function validateDigitInput(value){
	
	var digitRegExp = /^\d+$/;
	
	if(digitRegExp.test(value)==true){
		return true;
	}else{
		return false;
	}
}

/*
	This method validates that a field contains strings and special characters (-,()) along with with spaces
	
	KNOWN BUG : the validation fails for inputs like "asd   "
	SOLVED : replaced /(^\w+)((\s+)(\w+))*$/ with /(^\w+)((\s+)(\w*))*$/
*/
function validateStringWithSpacesInput(value){
	
	var stringWithSpaceRegExp = /(^[\w-,\(\)]+)((\s+)(\w-,\(\)))*$/;
	//alert(stringWithSpaceRegExp);
	
	if(stringWithSpaceRegExp.test(value)==true){
		//alert("2");
		return true;
	}else{
		//alert("3");
		return false;
	}
}