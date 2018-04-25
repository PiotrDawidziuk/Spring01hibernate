<%--
  Created by IntelliJ IDEA.
  User: piotrdawidziuk
  Date: 24.04.18
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Formularz</title>
</head>
<body>


<form:form method="post" modelAttribute="person">
    <label for="login">Login</label>
    <form:input type="text" name="login" id="login" path="login"/>
    <label for="password">Password</label>
    <form:input type="password" name="password" id="password" path="password"/>
    <label for="email">E-mail</label>
    <form:input type="email" name="email" id="email" path="email"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
