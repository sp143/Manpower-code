<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
<style type="text/css">
    span {
        display: inline-block;
        width: 200px;
        text-align: left;
    }
</style>
</head>
<body>
    <div align="center">
        <h2>Registration Succeeded!</h2>
        <span>Full name:</span><span>${consumer.fname}</span><br/>
        <%-- <span>E-mail:</span><span>${consumer.email}</span><br/>
        <span>Password:</span><span>${consumer.password}</span><br/>
        <span>Birthday:</span><span>${consumer.DOB}</span><br/>
        <span>Gender:</span><span>${consumer.gender}</span><br/>
        <span>Profession:</span><span>${consumer.profession}</span><br/> --%>
    </div>
</body>
</html>