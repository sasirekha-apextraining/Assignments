
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personal Info</title>
</head>
<body>
<form action="contactInfo" method="post">
    <h2>Please Enter Personal Information</h2>
		FirstName: <input type="text" name="firstName" required><br>
		LastName: <input type="text" name="lastName" required><br>
		MiddleName: <input type="text" name="middleName"><br>
		Gender: <input type="radio" name="gender" value="male"> Male <input
			type="radio" name="gender" value="female"> Female <input
			type="submit" value="Submit">
</form>
</body>
</html>