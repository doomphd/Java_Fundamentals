<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- //// CSS LINKS //////////////////////////////////////// -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>TV Show</title>
</head>
<body>

		<div class="container">
			<h1 class="text-primary text-align-center">TV Show Database</h1>
			<div class="row">
				<form:form class="col m-2 p-2 round" action="/"
					method="post" modelAttribute="newUser">
					<input type="hidden" name="_method" value="put">	
					<h2>Register:</h2>
					<div class="form-group">
						<label>User Name:</label> 
						<form:errors path="userName" class="text-danger alert mb-3" />
						<form:input path="userName" class="form-control mb-3" />
					</div>
					<div class="form-group">
						<label>Email:</label> 
						<form:errors path="email" class="text-danger text-danger alertmb-3" />
						<form:input path="email" class="form-control mb-3" />
					</div>
					<div class="form-group">
						<label>Password:</label> 
						<form:errors path="password" class="text-danger text-danger alertmb-3" />
						<form:password path="password" class="form-control mb-3" />
					</div>
					<div class="form-group">
						<label>Confirm Password:</label> 
						<form:errors path="confirm" class="text-danger text-danger alert mb-3" />
						<form:password path="confirm" class="form-control mb-3" />
					</div>
					<input type="submit" value="Register" class="btn btn-primary btn-sm round mb-3" />
				</form:form>


				<form:form class="col m-2 round p-2" action="/"
					method="post" modelAttribute="newLogin">
					<h2>Log-In</h2>
					<div class="form-group">
						<label>Email:</label>  
						<form:errors path="email" class="text-danger alert mb-3" />
						<form:input path="email" class="form-control mb-3" />
					</div>
					<div class="form-group">
						<label>Password:</label> 
						<form:errors path="password" class="text-danger alert mb-3" />
						<form:password path="password" class="form-control mb-3" />
					</div>
					<input type="submit" value="Login" class="btn btn-success btn-sm round mb-3" />
				</form:form>
			</div>
		</div>


	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>