<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Book!</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
  rel="stylesheet" 
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
  crossorigin="anonymous">
</head>
<body>
<div class="container">
<h3>Add a Book</h3>
  <form:form action="/books/new" method="post" modelAttribute="book">
    <form:input type="hidden" value="${ user_id }" path="creator" />
    <div class="form-group">
          <form:label path="title">Book Title:</form:label>
          <form:errors path="title"/>
          <form:input class="form-control" path="title" />
      </div>
      <div class="form-group">
          <form:label path="author">Author:</form:label>
          <form:errors path="author"/>
          <form:input class="form-control" path="author" />
      </div>
      <div class="form-group">
          <form:label path="rating">Rating:</form:label>
          <form:errors path="rating"/>
          <form:input class="form-control" path="rating" />
      </div>
      <button>Submit</button>
  </form:form>

</div>
</body>
</html>