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
<%--@elvariable id="author" type="pl.coderslab.model.Book"--%>
<form:form method="post" modelAttribute="author">
    <p><label for="firstName">First Name</label></p>
    <p><form:input path="firstName" name="firstName"/></p>
    <p><form:errors path="firstName" cssClass="error"/></p>
    <p><label for="lastName">Last Name</label></p>
    <p><form:input path="lastName" name="lastName"/></p>
    <p><form:errors path="lastName" cssClass="error"/></p>
    <p><label for="pesel">Pesel</label></p>
    <p><form:input path="pesel" name="pesel"/></p>
    <p><form:errors path="pesel" cssClass="error"/></p>
    <p><label for="email">E-Mail</label></p>
    <p><form:input path="email" name="email"/></p>
    <p><form:errors path="email" cssClass="error"/></p>

    <button type="submit">Submit</button>


</form:form>

<p><a href="/"><button>Powrót do Menu</button></a>
</body>
</html>