<%@ page import="com.directoryApp.model.DirectoryEntry"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" language="javascript" src="js/mainpageJavascriptFile.js"></script>
<link rel="stylesheet" type="text/css" href="css/new_file.css" />
<title>Add Or Search Contact</title>
</head>
<body onload="setResultsVisible('${ResultList}')">
	<div id="AddOrSearch" align="center">	
		<br>
		<form name="addOrSearchForm" onsubmit="return doYourWork()" action="">
			<table class="inputTable">
				<tr>
					<td align="right"><label >Name :</label></td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td align="right"><label >Company :</label></td>
					<td><input type="text" name="company"/></td>
				</tr>
				<tr>
					<td align="right"><label >Cell Number :</label></td>
					<td><input type="text" name="cellNumber"/></td>
				</tr>
				<tr>
					<td align="right"><label >Landline Number :</label></td>
					<td><input type="text" name="landlineNumber"/></td>
				</tr>
				<tr>
					<td align="right"><label >Email :</label></td>
					<td><input type="text" name="email"/></td>
				</tr>
				<tr>
					<td align="right"><label >Address :</label></td>
					<td><input type="text" height="5" name="address"/></td>
				</tr>
				<tr>
					<td><input type="submit" name="operation" value="ADD CONTACT" onclick="document.pressed=this.value"/></td>
					<td><input type="submit" name="operation" value="SEARCH CONTACT" onclick="document.pressed=this.value"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- Write code to check the "isSaved" attribute in which case a javascript message for successfully saved is to be displayed -->
	<c:if test="${isSaved != null }">
		<c:if test="${isSaved == true }"><br><center>Successfully Saved</center></c:if>
	</c:if>
	<div id="SearchResults" align="center">
		<!-- Write code to check for attribute "resultPage" and display the results accordingly -->
		<c:if test="${ResultList != null }">
			<br>
			<center> Search Successful !! </center>
			<br>
			<table border="1" class="resultTable">
				<tr>
					<td class="hidden">Contact ID</td>
					<td align="center"><b>Name</b></td>
					<td align="center"><b>Company</b></td>
					<td align="center"><b>Cell Number</b></td>
					<td align="center"><b>Landline Number</b></td>
					<td align="center"><b>Email</b></td>
					<td align="center"><b>Address</b></td>
					<td align="center"><b>Details</b></td>
				</tr>
			<c:forEach var="entry" items="${ResultList }">
				<tr>
					<td class="hidden">
						<input id="id" type="hidden" value="${entry.id }"/>
					</td>
					<td>
						<c:if test="${entry.name != null }">${entry.name }</c:if>
						<c:if test="${entry.name == null }"></c:if>	
					</td>
					<td>
						<c:if test="${entry.company != null }">${entry.company }</c:if>
						<c:if test="${entry.company == null }"></c:if>	
					</td>
					<td>
						<c:if test="${entry.cellNumber != null }">${entry.cellNumber }</c:if>
						<c:if test="${entry.cellNumber == null }"></c:if>
					</td>
					<td>
						<c:if test="${entry.landlineNumber != null }">${entry.landlineNumber }</c:if>
						<c:if test="${entry.landlineNumber == null }"></c:if>
					</td>
					<td>
						<c:if test="${entry.email != null }">${entry.email }</c:if>
						<c:if test="${entry.email == null }"></c:if>
					</td>
					<td>
						<c:if test="${entry.address != null }">${entry.address }</c:if>
						<c:if test="${entry.address == null }"></c:if>
					</td>
					<td>
						<center><input type="image" src="images/addSymbol.png" width="25" height="25" onclick="showInDetail();"/></center>
					</td>
				</tr>
			</c:forEach>
			</table>
		</c:if>				
	</div>
	<div id="Footer" align="center">
		<br>
		Application developed by : <b><c:out value='${initParam.admin1 }'/></b> and <b><c:out value='${initParam.admin2 }'/></b> (BOSS)
	</div>	
</body>

</html>