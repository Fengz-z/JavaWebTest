<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/15 0015
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
${sessionScope.message}<br>
<form action="CheckUserServlet" method="post">
    请输入用户名和口令：<br>
    用户名: <input type="text" name="username"><br>
    口 令： <input type="password" name="password"><br>
    <input type="checkbox" name="check" value="check" >自动登录<br>
    <input type="submit" value="登录">
    <input type="reset" value="取消">
</form>
</body>
</html>
