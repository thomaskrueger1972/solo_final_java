<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
  rel="stylesheet" 
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
  crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>"${book.title}" written by... ${book.author}</h1>
<a href="/books">Books</a>
<a href="/logout">Logout</a>
<hr>
<h3>Reader:</h3>
<c:if test="${book.reader.size() < 1 }" ><p>Nobody has read this book yet</p></c:if>
<ul>
<c:forEach items="${book.reader}" var="reader">
<li>${reader.firstName} ${reader.lastName}</li>
</c:forEach>
</ul>

</div>
</body>
</html>