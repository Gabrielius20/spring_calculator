<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10/04/2024
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Number update</title>
    <jsp:include page="header.jsp"/>
</head>

<body>

<form:form name="number" action="/updateNumber" method="post">
<input type="hidden" name="id" value="${number.id}">
<p>

    First number:<br>
    <input type="number" name="num1" value="${number.num1}">
<p>

    Operation:<br>
    <input type="text" name="operation" value="${number.operation}">
<p>

    Second number:<br>
    <input type="number" name="num2" value="${number.num2}">
<p>

    Result:<br>
    <input type="number" name="result" value="${number.result}">
    <input type="submit" value="Update">z

    </form:form>

</body>

</html>
