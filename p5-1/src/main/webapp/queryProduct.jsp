<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/29 0029
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品查询</title>
</head>
<body>
<p><a href="query-product">查询所有商品</a> </p>
<form action="query-product" method="post">
    请输入商品号:
    <input type="text" name="productid" size="15">
    <input type="submit" value="确定">
</form>
</body>
</html>
