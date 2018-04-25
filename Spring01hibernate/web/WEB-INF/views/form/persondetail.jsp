<%--
  Created by IntelliJ IDEA.
  User: piotrdawidziuk
  Date: 24.04.18
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Person Detail</title>
</head>
<body>

<form:form method="post" modelAttribute="persondetail">
    <label for="login">Login</label>
    <form:input type="text" name="login" id="login" path="login"/><br>
    <label for="password">Password</label>
    <form:input type="password" name="password" id="password" path="password"/><br>
    <label for="email">E-mail</label>
    <form:input type="email" name="email" id="email" path="email"/><br>
    <label for="firstName">First Name</label>
    <form:input type="text" name="firstName" id="firstName" path="firstName"/><br>
    <label for="lastName">Last Name</label>
    <form:input type="text" name="lastName" id="lastName" path="lastName"/><br>
    <label for="gender">Gender</label>
    <form:radiobuttons name="gender" id="gender" path="gender" items="${genders}"/><br>

    <label for="country">Country</label>
    <form:select name="country" id="country"  path="country" items="${countries}" /><br>
    <label for="notes">Notes</label>
    <form:textarea type="text" name="notes" id="notes" path="notes"/><br>
    <label for="mailingList">mailingList</label>
    <form:checkbox name="mailingList" id="mailingList" path="mailingList" /> <br>

    <label for="skills">Programming Skills</label>
    <form:select  name="skills" id="skills"  path="skills" items="${skills}" multiple="true"/><br>

    <label for="hobbies">Hobbies</label>
    <form:checkboxes id="hobbies" name="hobbies"  path="hobbies" items="${hobbies}" /><br>


    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
