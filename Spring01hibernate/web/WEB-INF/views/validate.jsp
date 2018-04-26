<%--
  Created by IntelliJ IDEA.
  User: piotrdawidziuk
  Date: 25.04.18
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Validate</title>
</head>
<body>
<h1>Errors:</h1>
<c:forEach items="${errors}" var="error">
    <p>${error.getPropertyPath()} ${error.getMessage()}</p>
</c:forEach>

<p><a href="/"><button>Powrót do Menu</button></a>
</body>
</html>
