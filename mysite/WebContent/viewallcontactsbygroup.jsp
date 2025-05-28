<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="assign.dbaccess.EMailAddressVOO"%>
<%@ include file="header.html"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
	<!--Body: view contact information-->
	<center>
		<table border="1" cellpadding="1" cellspacing="0" width="50%"">
			<tr>
                <th bgcolor="#FAFAF9" style="padding-left: 10px;">E-mail id</th>
                <th bgcolor="#FAFAF9" style="padding-left: 10px;">FirstName</th>
                <th bgcolor="#FAFAF9" style="padding-left: 10px;">MiddleName</th>
                <th bgcolor="#FAFAF9" style="padding-left: 10px;">LastName</th>
                <th bgcolor="#FAFAF9" style="padding-left: 10px;">HomePhone</th>
                <th bgcolor="#FAFAF9" style="padding-left: 10px;">WorkPhone</th>
                <th bgcolor="#FAFAF9" style="padding-left: 10px;">MobilePhone</th>
                <th bgcolor="#FAFAF9" style="padding-left: 10px;">Group</th>
            </tr>
            
            <c:forEach var="email" items="${emailList}">
                <tr>
                    <td bgcolor="#FAFAF9" style="padding-left: 10px;">
                    	<c:out value="${email.eMailID}" />
                    </td>
                    <td bgcolor="#FAFAF9" style="padding-left: 10px;">
                    	<c:out value="${email.getfName()}" />
                    </td>
                    <td bgcolor="#FAFAF9" style="padding-left: 10px;">
                    	<c:out value="${email.getmName()}" />
                    </td>
                    <td bgcolor="#FAFAF9" style="padding-left: 10px;">
                    	<c:out value="${email.getlName() }" />
                    </td>
                    <td bgcolor="#FAFAF9" style="padding-left: 10px;">
                    	<c:out value="${email.gethPhone()}" />
                    </td>
                    <td bgcolor="#FAFAF9" style="padding-left: 10px;">
                    	<c:out value="${email.getwPhone()}" />
                    </td>
                    <td bgcolor="#FAFAF9" style="padding-left: 10px;">
                    	<c:out value="${email.getmPhone()}" />
                    </td>
                    <td bgcolor="#FAFAF9" style="padding-left: 10px;">
                    	<c:out value="${email.getgroupID()}" />
                    </td>
                </tr>
            </c:forEach>
		</table>

	</center>
</body>
</html>