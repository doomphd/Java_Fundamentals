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

<!--/////////////////////////////////////////////////////
//	BOOKS ID JSP
/////////////////////////////////////////////////////////
	Shows the information on a single Book	 -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- //// CSS LINKS //////////////////////////////////////// -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Book Club</title>
</head>
<body>

		<div class="container mt-4">
			<h1>${ book.title }</h1>
			<div class=" round p-3">
				<h3>
					<label class="text-danger">${ book.user.userName }</label> read 
					<label class="text-primary">${ book.title }</label> by 
					<label class="text-success">${ book.author }</label>
				</h3>
				<p>Here are ${ book.user.userName }'s thoughts:</p>
				<div class="card p-3 round">
					<p>${ book.myThoughts }</p>
				</div>
				<c:choose>
						<c:when test="${user_id == book.user.id}">
							<div class="row mt-3">
								<div class="col-2">
								<a href="/books/${ book.id }/edit">Edit</a>
								</div>
								<form class="col-2" action="/books/${ book.id }/delete"
									method="post">
									<input type="hidden" name="_method" value="delete">
									<button class="btn btn-danger btn-sm round">Delete</button>
								</form>
							</div>
						</c:when>
					</c:choose>
			</div>
		</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>
</html>