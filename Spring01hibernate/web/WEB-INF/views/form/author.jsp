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
</head>
<body>
<%--@elvariable id="author" type="pl.coderslab.model.Book"--%>
<form:form method="post" modelAttribute="author">
    <label for="firstName">First Name</label>
    <form:input path="firstName" name="firstName"/>
    <label for="lastName">Last Name</label>
    <form:input path="lastName" name="lastName"/>
    <label for="pesel">Pesel</label>
    <form:input path="pesel" name="pesel"/>
    <label for="email">E-Mail</label>
    <form:input path="email" name="email"/>
  
    <button type="submit">Submit</button>
</form:form>
</body>
</html>