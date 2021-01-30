<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <link href="../resources/css/loginForm.css" rel="stylesheet" />
    <title>User Login Form</title>
    ...
  </head>
  <body>
    <div align="center" class="container">
      <h1>Admin/User Login Form</h1>
      <form:form action="login" method="Post" modelAttribute="login">
        <div >
          <form:label path="email">Username : </form:label>
          <form:input
            placeholder="Enter Username"
            path="email"
            required="true"
          />
          <form:label path="passWord">Password : </form:label>
          <form:input
            placeholder="Enter Password"
            path="passWord"
            required="true"
          />
          <form:button>Login</form:button>
          <form:input path="checkbox" checked="checked" /> Remember
          me|| Forgot <a href="#"> password? </a>
        </div>
      </form:form>
      <c:if test="${not empty message}"> Error: ${message} </c:if>
      
      <h1>${message}</h1>
      <h2>User Registration</h2>
      <form:form action="login" method="Post" modelAttribute="login">
        <form:label path="email">USER NAME:</form:label>
        <form:input path="email" required="true" />
        <br />

        <form:label path="passWord">PASSWORD:</form:label>
        <form:password path="passWord" required="true" />
        <br />

        <form:button>Login</form:button>
      </form:form>
     
    </div>
  </body>
</html>
 --%>


<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../assets/vendor/css/bootstrap.min.css">
<link href="../assets/vendor/fonts/circular-std/style.css"
	rel="stylesheet">
<link href="../resources/css/loginstyle.css" rel="stylesheet" />
<link rel="stylesheet"
	href="../assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
<style>
html, body {
	height: 100%;
}

body {
	display: -ms-flexbox;
	display: flex;
	-ms-flex-align: center;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
}
</style>
</head>

<body>
	<!-- ============================================================== -->
	<!-- login page  -->
	<!-- ============================================================== -->
	<div class="splash-container">
		<div class="card">
			<div class="card-header text-center">
				<a href="../index.html"><img class="logo-img"
					src="../assets/img/logo.png" alt="logo"></a><span
					class="splash-description">Please enter your user
					information.</span>
					<h4><red>${message}</red></h4>
			</div>
			<div class="card-body">
				<form:form action="login" method="Post" modelAttribute="login">
					<div class="form-group">
						<form:input class="form-control form-control-lg" path="email"
							type="text" placeholder="email" autocomplete="off" />
					</div>
					<div class="form-group">
						<form:input class="form-control form-control-lg" path="passWord"
							type="password" placeholder="Password" />
					</div>
					<div class="form-group">
						<form:label path="email" class="custom-control custom-checkbox">
							<input class="custom-control-input" type="checkbox">
							<span class="custom-control-label">Remember Me</span>
						</form:label>
					</div>
					<form:button type="submit" class="btn btn-primary btn-lg btn-block">Sign
						in</form:button>
				</form:form>
			</div>
			<div class="card-footer bg-white p-0  ">
				<div class="card-footer-item card-footer-item-bordered">
					<a href="/register" class="footer-link">Create An Account</a>
				</div>
				<div class="card-footer-item card-footer-item-bordered">
					<a href="forgotPassword" class="footer-link">Forgot Password</a>
				</div>
			</div>
		</div>
	</div>

	<!-- ============================================================== -->
	<!-- end login page  -->
	<!-- ============================================================== -->
	<!-- Optional JavaScript -->
	<script src="../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
</body>

</html>