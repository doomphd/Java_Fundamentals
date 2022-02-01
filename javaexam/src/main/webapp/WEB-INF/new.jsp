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
<title>New Show</title>
</head>
<body>

		<div class="container mt-4">
			<div class="row">
				<div class="col-10">
					<h1>Create a New TV Show</h1>
					<form:form class="round p-3" action="/shows/new" method="post"
						modelAttribute="newShow">

						<p class="form-group">
							<form:label path="title">Title:</form:label>
							<form:errors path="title" class="alert text-danger" />
							<form:input class="form-control mb-3" path="title" />
						</p>
						<p class="form-group">
							<form:label path="network">Network:</form:label>
							 <form:errors path="network" class="alert text-danger" />
							<form:input class="form-control mb-3" path="network" />
						</p>
						<p class="form-group">
							<form:label path="description">Description:</form:label>
							<form:errors path="description" class="alert text-danger" />
							<form:textarea class="form-control mb-3" path="description" />
						</p>
					<button class="btn btn-primary btn-sm round" type="submit" value="Submit">Submit</button>
						
					</form:form>
					<button class="btn btn-danger btn-sm round" onclick= "window.location.href='/shows';">Cancel</button>
					
					
				</div>
			</div>
		</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>
</html>

