<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/13 0013
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>登录界面</title>
</head>
<body>
${sessionScope.message}<br>
<form action="login" method="post">
    <table>
        <tr>
            <td>用户名: </td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
