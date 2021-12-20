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

	<a class="btn btn-primary " href="/omikuji">Omikuji Form</a>

</header>

		<div class="container mt-4 p-3">
			<h1>Here's Your Omikuji</h1>
			<h2>
				In <c:out value="${ number }"></c:out> years,
				you will live in <c:out value="${ city }"></c:out>
				with <c:out value="${ name }"></c:out>
				as your roomate, <c:out value="${ hobby }"></c:out>
				for a living.  The next time you see a <c:out value="${ livingThing }"></c:out>,
				you will have good luck.  Also, <c:out value="${ compliment }"></c:out>
			</h2>
		</div>
	
</body>
</html>