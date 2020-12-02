<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Registration Form</title>
<link href=".resources/css/bootstrap.min.css" rel="stylesheet"
	id="bootstrap-css">
<link href="./resources/css/styles.css" rel="stylesheet" />
<script src=".resources/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src=".resources/js/loginSignup.js"></script>
</head>
<body>
	<div class="container">
		<h1>SignUp Form</h1>
		<form:form class="form-horizontal" action="register" method="post"
			modelAttribute="user">
			<div class="form-group">
				<form:label path="fName" class="col-sm-3 control-label">First name:</form:label>
				<div class="col-sm-9">
					<form:input path="fName" required="true" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<form:label path="lName" class="col-sm-3 control-label">Last name:</form:label>
				<div class="col-sm-9">
					<form:input path="lName" required="true" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="email" class="col-sm-3 control-label">E-mail:</form:label>
				<div class="col-sm-9">
					<form:input path="email" required="true" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="phNo" class="col-sm-3 control-label">Phone No:</form:label>
				<div class="col-sm-9">
					<form:input path="phNo" required="true" class="form-control"
						maxlength="10" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="uName" class="col-sm-3 control-label">UserName:</form:label>
				<div class="col-sm-9">
					<form:input path="uName" required="true" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="password" class="col-sm-3 control-label">Password:</form:label>
				<div class="col-sm-9">
					<form:password path="password" placeholder="Password"
						required="true" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="DOB" class="col-sm-3 control-label">Birthday (yyyy-mm-dd):</form:label>
				<div class="col-sm-9">
					<form:input path="DOB" required="true" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="adhaarid" class="col-sm-3 control-label">Aadhaar:</form:label>
				<div class="col-sm-9">
					<form:input path="adhaarid" required="true" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="Gender" class="col-sm-3 control-label">Gender:</form:label>
				<div class="col-sm-9">
					<form:radiobutton path="Gender" value="Male" />
					Male
					<form:radiobutton path="Gender" value="Female" required="true"
						class="form-control" />
					Female
				</div>
			</div>
			<div class="form-group">
				<form:label path="profession" class="col-sm-3 control-label">Role:</form:label>
				<div class="col-sm-9">
					<form:select path="profession">
						<form:option value="NONE"> --SELECT--</form:option>
						<form:options items="${listOfRoles}"></form:options>
					</form:select>
				</div>
				<%-- <form:label path="profession" class="col-sm-3 control-label">Role:</form:label>
				<div class="col-sm-9">
					<form:input path="profession" required="true" class="form-control" />
				</div> --%>
			</div>
			<div class="form-group">
				<div class="wthree-text">
					<label class="anim" class="col-sm-3 control-label"> <form:checkbox
							path="checkboxcondition" class="checkbox" required="true" /> <span>I
							Agree To The Terms &amp; Conditions</span>
					</label>
				</div>
			</div>
			<form:button>Register</form:button>
			<p>
				Don't have an Account? <a href="/login"> Login Now!</a>
			</p>
		</form:form>
	</div>
</body>
</html>

<!-- ./container -->