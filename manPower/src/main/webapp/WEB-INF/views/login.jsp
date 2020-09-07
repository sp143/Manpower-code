<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Form</title> ...

</head>
<body>
	<div align="center">
		<h2>User Registration</h2>
		<form:form action="login" method="get" modelAttribute="login">	
			<form:label path="uName">Password:</form:label>
			<form:password path="uName" />
			<br />

			<form:label path="password">Password:</form:label>
			<form:password path="password" />
			<br />
			
			<form:button>Login</form:button>
		</form:form>
	</div>
</body>
</html>