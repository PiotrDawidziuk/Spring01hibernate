<%--
  Created by IntelliJ IDEA.
  User: kkonieczny
  Date: 24/04/2018
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Title</td>
        <td>Rating</td>
        <td>Description</td>
        <td>Akcje</td>
    </tr>
    <%--@elvariable id="book" type="pl.coderslab.model.Book"--%>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td> <a href="/deletebook/${book.id}">usuń</a></td>
            <td> <a href="/update/${book.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>