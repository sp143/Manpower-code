<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./resources/css/loginForm.css" rel="stylesheet" />
<title>User Login Form</title> ...

</head>
<body>
	<div align="center">
		<h1>Student Login Form</h1>
		<form:form action="login" method="Post" modelAttribute="login">
			<div class="container">
				<form:label path="email">Username : </form:label>
				<form:input  placeholder="Enter Username" path="email"
					required="true" />
				<form:label path="passWord">Password
					: </form:label>
				<form:input  placeholder="Enter Password"
					path="passWord" required="true" />
				<form:button>Login</form:button>
				<%-- <form:input path="checkbox" checked="checked" /> --%>
				Remember me||
				Forgot <a href="#"> password? </a>
			</div>
		</form:form>
		<%-- <c:if test="${not empty message}">
   Error: ${message}
</c:if> --%>
		<%--<h1>${message}</h1>
		<h2>User Registration</h2>
		<form:form action="login" method="Post" modelAttribute="login">
			<form:label path="email">USER NAME:</form:label>
			<form:input path="email" required="true" />
			<br />

			<form:label path="passWord">PASSWORD:</form:label>
			<form:password path="passWord" required="true" />
			<br />

			<form:button>Login</form:button>
		</form:form> --%>
	</div>
</body>
</html>