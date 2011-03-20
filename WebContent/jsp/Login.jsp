<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/new_file.css" />
<script type="text/javascript" language="javascript" src="js/validation.js"></script>
<script type="text/javascript" language="javascript" src="js/loginJavascriptFile.js"></script>
<title>Login Page</title>
</head>
<body onload="setUserValidateFailedVisible('${validUser}');">
	<div id="userValidateFailed" align="center" >
		<b>User Staff No. and Password do not match, Please Re-Enter the data</b>
	</div>
	<div id="LoginForm" align="center">
		<br>
		<form id="loginForm" action="" method="post" onsubmit="return validateAndSubmit(this);">
			<table id="inputTable">
				<tr>
					<td align="right"><label>Staff Number</label></td>
					<td><input type="text" id="staffNo" name="staffNo" maxlength="7"/></td>
				</tr>
				<tr>
					<td align="right"><label>Password</label></td>
					<td><input type="password" id="password" name="password" maxlength="20"/></td>
				</tr>
			</table>
			<table>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" value="LOGIN" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>