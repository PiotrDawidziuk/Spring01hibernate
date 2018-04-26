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
<%--@elvariable id="publisher" type="pl.coderslab.model.Book"--%>
<form:form method="post" modelAttribute="publisher">
    <p><label for="name">Name</label></p>
    <p><form:input path="name" name="name"/></p>
    <p><form:errors path="name" cssClass="error"/></p>
    <p><label for="nip">NIP</label></p>
    <p><form:input path="nip" name="nip"/></p>
    <p><form:errors path="nip" cssClass="error"/></p>
    <p><label for="regon">REGON</label></p>
    <p><form:input path="regon" name="regon"/></p>
    <p><form:errors path="regon" cssClass="error"/></p>

    <button type="submit">Submit</button>
</form:form>
<p><a href="/"><button>Powrót do Menu</button></a>
</body>
</html>