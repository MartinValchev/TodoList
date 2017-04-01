<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>
	<div class="panel panel-default">
		<h3 class="panel-heading">Login</h3>
		<div class="panel-body">
			<form action="/TodoList/UserLoginServlet" method="post">
				Username: <input type="text" name="username"> <br>
				Password: <input type="password" name="password"> <br>
				<input type="submit" class="btn btn-default" value="Login">
			</form>
		</div>
	</div>
	<br><br>
<p><a href="/TodoList/html/index.html" style="color:yellow;" class="btn btn-primary" >Return to main page</a></p>
	<p>
	<div class="panel-body">
	<ul style="list-style-type: none">
		<c:forEach items="${errorMessages}" var="errorMessage">
			<li style="color:red;">${errorMessage}</li>
			<br>	
	</c:forEach>
	</ul>
	</div>
	<p>
</body>
</html>