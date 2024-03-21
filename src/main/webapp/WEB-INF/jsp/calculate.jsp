<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <title>Skaičiuoti</title>
    </head>
    <body>
        <%
            String error = (String) request.getAttribute("error");
            if (error == null || error.isEmpty()) {
        %>
                <h2>${num1} ${operation} ${num2} = ${result}</h2>
        <%
            } else {
        %>
                <h2><%= error %></h2>
        <%
            }
        %>
    </body>
</html>