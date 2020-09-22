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
			<form:label path="fName">First name:</form:label>
			<form:input path="fName" />
			<br />
			<form:label path="lName">Last name:</form:label>
			<form:input path="lName" />
			<br />

			<form:label path="email">E-mail:</form:label>
			<form:input path="email" />
			<br />

			<form:label path="phNo">Phone No:</form:label>
			<form:input path="phNo" /> 
			<br />

			<form:label path="uName">UserName:</form:label>
			<form:input path="uName" />
			<br />

			<form:label path="password">Password:</form:label>
			<form:password path="password" />
			<br />

			<form:label path="DOB">Birthday (yyyy-mm-dd):</form:label>
			<form:input path="DOB" />
			<br />
			
			<form:label path="adhaarid">Aadhaar:</form:label>
			<form:input path="adhaarid" />
			<br />

			<form:label path="Gender">Gender:</form:label>
			<form:radiobutton path="Gender" value="Male" />Male
			<form:radiobutton path="Gender" value="Female" />Female<br />

			<form:label path="profession">Profession:</form:label>
			<form:input path="profession" />
			<br />



			<form:button>Register</form:button>
		</form:form>
	</div>
</body>
</html>