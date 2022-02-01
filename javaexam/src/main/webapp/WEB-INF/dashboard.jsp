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
<title>Dashboard</title>
</head>
<body>

		<div class="container mt-4">
			<div class="row">
				<div class="d-flex justify-content-between align-items-center">
					<h1>Welcome, ${ loggedInUser.userName }</h1>
						<div class="d-flex justify-content-end align-items-center">
							<a href = "/logout">logout</a>
						</div>
				</div>
				<div class="round p-3">
						<h2>TV Shows</h2>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Title</th>
								<th scope="col">Network</th>
					
							</tr>
						</thead>
						<tbody>
							<c:forEach var="show" items="${ showList }">
								<tr>
									<td><a href="/shows/${ show.id }">${ show.title }</a></td>
									<td>${ show.network }</td>
	
								</tr>
							</c:forEach>
						</tbody>
					</table>
				<button class="btn btn-primary btn-sm round" onclick= "window.location.href='/shows/new';">Add a Show</button>
				</div>
			</div>
		</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>
</html>