<%--
  Created by IntelliJ IDEA.
  User: piotrdawidziuk
  Date: 26.04.18
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete</title>
</head>
<body>
<p>Czy jesteś pewien, że chcesz usunąć pozycję o ID ${id}</p>
<a href="/deletebook/${id}"><button>Delete</button></a>
<a href="/list"><button>Cancel</button></a>
</body>
</html>
