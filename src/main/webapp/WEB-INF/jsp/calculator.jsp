<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
    <style>
        .error{color:red}
    </style>
</head>
<body>
    <h2>Web Calculator. Operations: Add | Subtract | Multiply | Divide</h2>
    <form:form method="post" action="calculate" modelAttribute="number">
        First number: <form:input type="number" path="num1"/>
                      <form:errors path="num1" cssClass="error"/><br><br>

        Second number: <form:input type="number" path="num2"/>
                       <form:errors path="num2" cssClass="error"/><br><br>
        Operation symbol:
        <select name="symbol">
                <option selected="selected" value="+">Add</option>
                <option value="-">Subtract</option>
                <option value="*">Multiply</option>
                <option value="/">Divide</option>
        </select><p>
        <input type="submit" value="calculate">
    </form:form>

    <% if (request.getAttribute("divisionError") != null) { %>
        <div class="divisionError">
            Error: ${divisionError}
        </div>
    <% } %>
</body>
</html>