<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10/04/2024
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="http://localhost:8080">Calculator</a>
        </div>
        <ul class="nav navbar-nav navbar-left">
            <li class="active">
                <a href="${pageContext.request.contextPath}/numbers">Operations</a>
            </li>
        </ul>
    </div>
</nav>
