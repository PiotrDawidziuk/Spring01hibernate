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
    <style>table, th, td {
        border: 1px solid black; padding: 2px; text-align: center;
    }</style>
</head>
<body>
<table>
    <tr>
        <td>Title</td>
        <td>Rating</td>
        <td>Description</td>
        <td>Publisher</td>
        <td>Author</td>
        <td>Delete</td>
        <td>Edit</td>
    </tr>
    <%--@elvariable id="book" type="pl.coderslab.model.Book"--%>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.description}</td>
            <td>${book.publisher}</td>
            <td>${book.author}</td>
            <td> <a href="/deletebook/${book.id}"><button>usuń</button></a></td>
            <td> <a href="/update/${book.id}"><button>Edytuj</button></a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="/"><button>Powrót do Menu</button></a>
</body>
</html>