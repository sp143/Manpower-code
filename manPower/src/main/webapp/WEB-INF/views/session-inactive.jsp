<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>Session Inactive</title>
<link rel="icon" href='<c:url value= "./resources/img/title-logo.png"/>'
	type="image/x-icon">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href='<c:url value= "./resources/css/style.css" />'>
<link rel="stylesheet"
	href='<c:url value= "./resources/css/submit-style.css" />'>
<link rel="stylesheet"
	href='<c:url value= "./resources/css/jquery.dynatable.css"/>'>
<link rel="stylesheet"
	href='<c:url value= "./resources/css/nice-select.css" />'>
<link rel="stylesheet"
	href='<c:url value= "./resources/css/bootstrap.min.css"/>'>
<link rel="stylesheet"
	href='<c:url value= "./resources/dashboard/css/style.css"/>'>
</head>
<body>
	<div class="dashboard-main-wrapper p-0">
		<nav class="navbar navbar-expand dashboard-top-header bg-white">
			<%-- <div class="container-fluid">
				<div class="dashboard-nav-brand">
					<a class="navbar-brand" href='<c:url value = "/user/"/>'><img
					class="logo-img" src='<c:url value= "./resources/img/logo.png"/>' width="130px;"
					height="55px;" alt="logo"></a>
				</div>
			</div> --%>
		</nav>
		<div class="bg-light text-center">
			<div class="container">
				<div class="row">
					<div
						class="offset-xl-2 col-xl-8 offset-lg-2 col-lg-8 col-md-12 col-sm-12 col-12">
						<div class="error-section">
							<img src="img/error-img.png" alt="" class="img-fluid">
							<div class="error-section-content">
								<h1 class="display-3">SESSION EXPIRED</h1>
								<p>Sorry, your session has been
								<h4>Expired</h4>
								please Login Again.
								<p>
									<a href='<c:url value = "/"/>' class="btn btn-secondary btn-lg">Back
										to Home</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="bg-white p-3">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-3">
							<div class="footer-logo">
								<div class="logo">
									<a href="/merojameen"><img
										src='<c:url value= "./resources/img/logo.png"/>' alt=""
										height="50px;"></a>
								</div>
							</div>
						</div>
						<div class="col-xl-8 col-lg-8 col-md-12 col-sm-12 col-12">
							Copyright © 2020 Mero Jameen. All rights reserved. Dashboard by :
							Ranjan.</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>