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
<%--@elvariable id="publisher" type="pl.coderslab.model.Book"--%>
<form:form method="post" modelAttribute="publisher">
    <label for="name">Name</label>
    <form:input path="name" name="name"/>
    <label for="nip">NIP</label>
    <form:input path="nip" name="nip"/>
    <label for="regon">REGON</label>
    <form:input path="regon" name="regon"/>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>