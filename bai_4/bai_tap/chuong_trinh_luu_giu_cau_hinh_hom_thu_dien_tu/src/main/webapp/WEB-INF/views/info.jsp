<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 27/10/2021
  Time: 7:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body >
<h1>Settings</h1>
<br>

<form:form modelAttribute="email" action="/email/update" method="post">
    <table >
        <tr>
            <th>Languages</th>
            <td>
                <form:select multiple="" size="1" path="languages" items="${languageList}"/>
            </td>
        </tr>
        <tr>
            <th>Page Size:</th>
            <td>
                <span>Show </span><form:select multiple="" size="1" path="pageSize" items="${sizeList}"/><span>email per page </span>
            </td>
        </tr>
        <tr>
            <th>Spams filter:</th>
            <td>
                <form:radiobutton path="spamsFilter" value="0" label="Enabale"/>
                <form:radiobutton path="spamsFilter" value="1" label="Disable   "/>
            </td>
        </tr>
        <tr>
            <th>Signature:</th>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td >
                <button type="submit" style="color: green;background-color:lawngreen">Update</button>
            </td>
            <td >
                <button style="color: green">Cancel</button>
            </td>

        </tr>
    </table>
</form:form>

</body>
</html>
