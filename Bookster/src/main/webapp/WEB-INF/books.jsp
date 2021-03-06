<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Bookster!</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome, ${user.firstName}</h1>
<a href="/logout">Logout</a> <a href="/books/new">Add a Book!</a>

<hr>

<table class="table table-dark table-hover">
<thead>
<tr>
<th>Title</th>
<th>Author</th>
<th>Rating</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach items="${books}" var="book">
<tr>
<td><a href="/books/${book.id}">${book.title}</a></td>
<td><a href="/books/${book.id}">${book.author}</a></td>
<td><a href="/books/${book.id}">${book.rating}</a></td>
<c:choose>
<c:when test="${book.creator.id == user.id}">
<td><a href="/books/delete/${book.id}">Delete</a></td>
</c:when>
<c:when test="${book.reader.contains(user)}">
<td><a href="/books/drop/${book.id}">Drop Book</a></td>
</c:when>
<c:otherwise>
<td><a href="/books/add/${book.id}">Read Book</a></td>
</c:otherwise>
</c:choose>
</tr>

</c:forEach>
</tbody>

</table>
</div>
</body>
</html>