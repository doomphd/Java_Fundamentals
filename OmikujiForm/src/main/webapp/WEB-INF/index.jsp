<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset ="UTF-8">
	<title>Home Page</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	
	<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<header>		
	
	<a class="btn btn-primary" href="/omikuji">Omikuji Form</a>
	
</header>

		<div class="container mt-4 p-3">
			<h1>Send an Omikuji!</h1>
			<form action="/omikuji/post" method="post">
				<label for="number">Pick a number from 5 to 25:</label>
				<input type="number" id="number" name="number" min="5" max="25">
				<div class="form-group mb-2">
					<label class="form-label" for="city">Enter the name of a City:</label>
					 <input class="form-control" type="text" id="city" name="city">
				</div>
				<div class="form-group mb-2">
					<label class="form-label" for="name">Enter the name of a real person:</label>
					 <input class="form-control" type="text" id="name" name="name">
				</div>
				<div class="form-group mb-2">
					<label class="form-label" for="hobby">Enter a professional endeavor or hobby:</label>
					 <input class="form-control" type="text" id="hobby" name="hobby">
				</div>
				<div class="form-group mb-2">
					<label class="form-label" for="livingThing">Enter any type of living thing:</label>
					 <input class="form-control" type="text" id="livingThing" name="livingThing">
				</div>
				<div class="form-group mb-2">
					<label for="compliment">Say something nice to someone:</label>
					<textarea class="form-control" id="compliment" name="compliment" rows="5"></textarea>
				</div>
				Send and show a friend
				<input class="btn btn-primary" type="submit">
			</form>

		</div>
  


	
</body>
</html>