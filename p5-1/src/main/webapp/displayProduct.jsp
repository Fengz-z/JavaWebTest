<%@ page import="java.util.ArrayList" %>
<%@ page import="com.demo.Product" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/29 0029
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有商品</title>
</head>
<body>
<table border="1">
    <tr>
        <td>商品号</td>
        <td>商品名</td>
        <td>品牌</td>
        <td>价格</td>
        <td>数量</td>
    </tr>
    <% ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("productList");
    for (Product product : productList){
        %>
    <tr>
        <td><%= product.getId()%></td>
        <td><%= product.getPname()%></td>
        <td><%= product.getBrand()%></td>
        <td><%= product.getPrice()%></td>
        <td><%= product.getStock()%></td>
    </tr>
    <% } %>


</table>
</body>
</html>
