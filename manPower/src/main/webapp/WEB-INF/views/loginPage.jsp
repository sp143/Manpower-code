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
		<%-- <c:if test="${not empty message}">
   Error: ${message}
</c:if> --%>
		<h1>${message}</h1>
		<h2>User Registration</h2>
		<form:form action="login" method="get" modelAttribute="login">
			<form:label path="userName">USER NAME:</form:label>
			<form:password path="userName" />
			<br />

			<form:label path="passWord">PASSWORD:</form:label>
			<form:password path="passWord" />
			<br />

			<form:button>Login</form:button>
		</form:form>
	</div>
</body>
</html>