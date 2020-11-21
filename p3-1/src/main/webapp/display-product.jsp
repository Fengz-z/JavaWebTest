<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/12 0012
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="product" class="com.sirifeng.Product" scope="request" />
<html>
<head>
    <title>商品信息</title>
</head>
<body>
<table border="1">
    <caption>商品信息如下</caption>
    <tr>
        <td>商品号：</td>
        <td><jsp:getProperty name="product" property="id"/></td>
    </tr>
    <tr>
        <td>商品名：</td>
        <td><jsp:getProperty name="product" property="name"/></td>
    </tr>
    <tr>
        <td>价格：</td>
        <td><jsp:getProperty name="product" property="price"/></td>
    </tr>
</table>
</body>
</html>
