<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/26 0026
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>GuessNumber Game</title>
</head>
<body>
<font color="red">${message}</font>
<form action="GuessNumberServlet" method="post" >

        <p>我有一个在0-100的正整数，请你来猜一下~<br>
        <input type="text" name="guess"><input type="submit" name="submit" value="确定">
</form>
</body>
</html>
