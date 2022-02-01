<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<table class="table table-striped">
   			<tr>
   				<th> ID </th>
   				<th> Gift </th>
   				<th> Quantity </th>
   				<th> Description </th>
   			</tr>			
				<tr>
					<td>${gift.id }</td>
					<td>${gift.name }</td>
					<td>${gift.quantity} </td>
					<td>${gift.description }</td>
				</tr>
		</table>	
	<a href="/gifts/${gift.id}/edit" class="btn btn-success"> Edit </a>
	
	<form action="/gifts/${gift.id}/delete" method="post">
		<input type="hidden" name="_method" value="delete" />
		<button class="btn btn-danger"> Delete</button>
	</form>
	
	</div>
</body>
</html>