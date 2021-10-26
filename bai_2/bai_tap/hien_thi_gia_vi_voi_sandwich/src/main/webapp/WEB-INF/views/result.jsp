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
    <title>Result</title>
</head>
<body>

<c:if test='${condiment != null}'>
    <span style="font-size: xx-large;color: blue">Your sandwich with condiment: </span>
    <c:forEach var="c" items="${condiment}">
        <span style="font-size: xx-large;color: red">${c}</span>
    </c:forEach>
</c:if>


</body>
</html>
