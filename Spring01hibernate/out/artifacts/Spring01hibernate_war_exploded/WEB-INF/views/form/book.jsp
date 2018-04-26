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
    <title>Title</title>
    <style> .error{color:red; background-color: yellow;}</style>
</head>
<body>
<%--@elvariable id="book" type="pl.coderslab.model.Book"--%>
<form:form method="post" modelAttribute="book">
    <p><label for="title">Title</label></p>
    <p><form:input path="title" name="title"/></p>
    <p><form:errors path="title" cssClass="error"/></p>
    <p><label for="rating">Rating</label></p>
    <p><form:input path="rating" name="rating"/></p>
    <p><form:errors path="rating" cssClass="error"/></p>
    <p><label for="description">Description</label></p>
    <p><form:input path="description" name="description"/></p>
    <p><form:errors path="description" cssClass="error"/></p>
    <p><form:select path="publisher" items="${publishers}" itemValue="name" itemLabel="name"/></p>
    <p><form:select path="author" items="${authors}" itemValue="lastName" itemLabel="lastName"/></p>
    <button type="submit">Submit</button>
</form:form>
<p><a href="/"><button>Powrót do Menu</button></a>
</body>
</html>