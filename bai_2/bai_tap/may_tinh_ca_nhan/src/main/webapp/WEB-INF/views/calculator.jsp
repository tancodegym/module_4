<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/10/2021
  Time: 9:51 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Calculator</title>
</head>
<body style="text-align: center;">
<h1 style="color: orange">Calculator</h1>
<form action="calculate">
    <input type="text" name="number_a" placeholder="0">
    <input type="text" name="number_b" placeholder="0"><br><br>
    <input type="submit" name="calculate" value="Addition(+)">
    <input type="submit" name="calculate" value="Subtraction(-)">
    <input type="submit" name="calculate" value="Multiplication(*)">
    <input type="submit" name="calculate" value="Division(/)">

</form>

<h4 style="color: blue">Result <p style="color:red">${result}</p></h4>


<%--<c:if test='${condiment != null}'>--%>
<%--    <span style="font-size: xx-large;color: blue">Your sandwich with condiment: </span>--%>
<%--    <c:forEach var="c" items="${condiment}">--%>
<%--        <span style="font-size: xx-large;color: red">${c}</span>--%>
<%--    </c:forEach>--%>
<%--</c:if>--%>


</body>
</html>
