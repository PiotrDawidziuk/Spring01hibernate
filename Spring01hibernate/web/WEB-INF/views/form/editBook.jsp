<%--
  Created by IntelliJ IDEA.
  User: kkonieczny
  Date: 24/04/2018
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<%--@elvariable id="book" type="pl.coderslab.model.Book"--%>
<form:form method="post" modelAttribute="book">
    <label for="title">Title</label>
    <form:input path="title" name="title"/>
    <label for="rating">Rating</label>
    <form:input path="rating" name="rating"/>
    <label for="description">Description</label>
    <form:input path="description" name="description"/>
    <form:select path="publisher" items="${publishers}" itemValue="id" itemLabel="name"/>
    <form:select path="author" items="${authors}" itemValue="id" itemLabel="lastName"/>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>