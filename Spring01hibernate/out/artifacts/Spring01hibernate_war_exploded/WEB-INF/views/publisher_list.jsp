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
        <td>Name</td>
        <td>NIP</td>
        <td>REGON</td>
    </tr>
    <%--@elvariable id="book" type="pl.coderslab.model.Book"--%>
    <c:forEach items="${publishers}" var="publisher">
        <tr>
            <td>${publisher.name}</td>
            <td>${publisher.nip}</td>
            <td>${publisher.regon}</td>
            <td> <a href="/deletepublisher/${publisher.id}"><button>Usuń</button></a></td>
            <td> <a href="/updatepublisher/${publisher.id}"><button>Edytuj</button></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>