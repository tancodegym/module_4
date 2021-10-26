<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/10/2021
  Time: 9:39 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich Condiments</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="sandwich" style="font-size: xx-large">
  <input type="checkbox" name="condiment" value="lettuce">Lettuce
  <input type="checkbox" name="condiment" value="tomato">Tomato
  <input type="checkbox" name="condiment" value="mustard">Mustard
  <input type="checkbox" name="condiment" value="sprouts">Sprouts
  <hr>
    <input type="submit" name="save" value="save">
  </form>
  </body>
</html>
