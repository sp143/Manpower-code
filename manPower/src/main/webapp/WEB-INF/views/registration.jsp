<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title> ...
<style type="text/css">
label {
	display: inline-block;
	width: 200px;
	margin: 5px;
	text-align: left;
}

input[type=text], input[type=password], select {
	width: 200px;
}

input[type=radio] {
	display: inline-block;
	margin-left: 45px;
}

input[type=checkbox] {
	display: inline-block;
	margin-right: 190px;
}

button {
	padding: 10px;
	margin: 10px;
}
</style>
</head>
<body>
	<div align="center">
		<h2>User Registration</h2>
		<form:form action="register" method="post" modelAttribute="consumer">
			<form:label path="fname">First name:</form:label>
			<form:input path="fname" />
			<br />
			<form:label path="lname">Last name:</form:label>
			<form:input path="lname" />
			<br />

			<form:label path="email">E-mail:</form:label>
			<form:input path="email" />
			<br />

			<form:label path="phNo">Phone No:</form:label>
			<form:input path="phNo" />
			<br />

			<form:label path="uName">Password:</form:label>
			<form:password path="uName" />
			<br />

			<form:label path="password">Password:</form:label>
			<form:password path="password" />
			<br />

			<form:label path="birthday">Birthday (yyyy-mm-dd):</form:label>
			<form:input path="birthday" />
			<br />

			<form:label path="gender">Gender:</form:label>
			<form:radiobutton path="gender" value="Male" />Male
			<form:radiobutton path="gender" value="Female" />Female<br />

			<form:label path="profession">Profession:</form:label>
			<form:select path="profession" />
			<br />



			<form:button>Register</form:button>
		</form:form>
	</div>
</body>
</html>