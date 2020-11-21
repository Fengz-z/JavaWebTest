<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/12 0012
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="/ServletForward" method="post">
    姓名<input type="text" name="sname" size="15"/><br>
    学号<input type="text" name="sno" size="15"/><br>
    <input type="submit" value="登录"/>
    <input type="reset" value="取消" />
</form>
</body>
</html>
