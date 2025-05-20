<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Info</title>
</head>
<body>
	<%
    session.setAttribute("address", request.getParameter("address"));
	session.setAttribute("city", request.getParameter("city"));
	session.setAttribute("state", request.getParameter("state"));
	session.setAttribute("country", request.getParameter("country"));
	session.setAttribute("phoneNumber", request.getParameter("phoneNumber"));
%>
	<form action="registerServlet" method="post">
		<h3>Bank Information</h3>
		<label for="bankName">Bank Name:</label> <select id="bankName"
			name="bankName">
			<option value="bofa">Bank Of America</option>
			<option value="chase">Chase</option>
			<option value="city">CityBank</option>
		</select><br> Account Number: <input type="number" name="accountNumber"
			required><br> SSN: <input type="number" name="ssn"
			required><br> <input type="submit" value="Submit">
	</form>
</body>
</html>