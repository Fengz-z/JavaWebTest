<%--
  Created by IntelliJ IDEA.
  User: SiriFeng
  Date: 2020/11/10 0010
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找图书</title>
</head>
<body>
<form action="findBook" method="post">
    <table>
        <tr>请输入图书编号：</tr>
        <tr><input type="text" name="isbn"></tr>
        <tr><input type="submit"></tr>
    </table>
</form>
</body>
</html>
