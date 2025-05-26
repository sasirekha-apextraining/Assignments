
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="assign.dbaccess.EMailAddressVOO"%>
<%@ include file="header.html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View all contacts</title>
</head>
<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">
	<center>
		<h2>View Contacts</h2>
		<%@include file="displayformerrors.jsp"%>
	</center>
	<% List<EMailAddressVOO> emailList = (List<EMailAddressVOO>)session.getAttribute("emailList");
	
    for(EMailAddressVOO email : emailList){
    %>
	<!--Body: view contact information-->
	<center>
		<table border="1" cellpadding="1" cellspacing="0" width="50%"">
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">E-mail id</td>
				<td><%= email.geteMailID() %></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">firstName</td>
				<td><%= email.getfName() %></td>
			</tr>

			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">LastName</td>
				<td><%= email.getlName() %></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">MiddleName</td>
				<td><%= email.getmName() %></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">HomePhone</td>
				<td><%= email.gethPhone() %></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">MobilePhone</td>
				<td><%= email.getmPhone() %></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">WorkPhone</td>
				<td><%= email.getwPhone() %></td>
			</tr>
			<tr>
				<td bgcolor="#FAFAF9" style="padding-left: 10px;">Group</td>
				<td><%= email.getgroupID() %></td>
			</tr>
		</table>

	</center>
    
    <%
    }
    %>
</body>
</html>