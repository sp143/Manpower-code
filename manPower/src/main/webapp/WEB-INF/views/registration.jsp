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
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- Custom Theme files -->
<link href="/css/praveenStyles.css" rel="stylesheet" type="text/css"
	media="all" >
<!-- //Custom Theme files -->
<!-- web font -->
<link
	href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i"
	rel="stylesheet">
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
	<h1>${message}</h1>
	<div class="main-w3layouts wrapper">
		<h1>SignUp Form</h1>
		<div class="main-agileinfo">
			<div class="agileits-top">
				<form:form action="register" method="post" modelAttribute="consumer">
					<form:label path="fName">First name:</form:label>
					<form:input path="fName" required="true" />
					<br />
					<form:label path="lName">Last name:</form:label>
					<form:input path="lName" required="true" />
					<br />

					<form:label path="email">E-mail:</form:label>
					<form:input path="email" required="true" />
					<br />

					<form:label path="phNo">Phone No:</form:label>
					<form:input path="phNo" required="true" />
					<br />

					<form:label path="uName">UserName:</form:label>
					<form:input path="uName" required="true" />
					<br />

					<form:label path="password">Password:</form:label>
					<form:password class="text w3lpass" path="password" placeholder="Password" required="true" />
					<br />

					<form:label path="DOB">Birthday (yyyy-mm-dd):</form:label>
					<form:input path="DOB" required="true" />
					<br />

					<form:label path="adhaarid">Aadhaar:</form:label>
					<form:input path="adhaarid" required="true" />
					<br />

					<form:label path="Gender">Gender:</form:label>
					<form:radiobutton path="Gender" value="Male" />Male
			<form:radiobutton path="Gender" value="Female" required="true" />Female<br />

					<form:label path="profession">Profession:</form:label>
					<form:input path="profession" required="true"  />
					<br />
					<div class="wthree-text">
						<label class="anim"> <form:checkbox path="checkboxcondition" 
								class="checkbox" required="true" /> <span>I Agree To The
								Terms & Conditions</span>
						</label>
						<div class="clear"></div>
					</div>
					<form:button>Register</form:button>
				</form:form>
				<p>Don't have an Account? <a href="#"> Login Now!</a></p>
			</div>
			</div>
			</div>
</body>
</html>