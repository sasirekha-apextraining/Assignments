
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Info</title>
</head>
<body>
<form action="bankInfo" method="post">
    <h3>Please Enter Contact Information</h3>
		Address: <input type="text" name="address" required><br>
		City: <input type="text" name="city" required><br> State:
		<input type="text" name="state" required><br> <label
			for="country">country:</label> <select id="country" name="country">
			<option value="us">United States</option>
			<option value="ca">Canada</option>
			<option value="uk">United Kingdom</option>
			<option value="au">Australia</option>
			<option value="in">India</option>
		</select><br> Phone Number: <input type="number" name="phoneNumber" required><br>

		<input type="submit" value="Submit">
</form>
</body>
</html>