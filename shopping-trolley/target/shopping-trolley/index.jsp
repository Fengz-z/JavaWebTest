<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sirifeng.Product" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/13 0013
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物系统首页面</title>
</head>
<body>
<center>
    <h3>商品列表</h3>
    <table>
        <tr>
            <td>商品号</td><td>商品名</td><td>价格</td><td>库存量</td><td>说明</td><td>详细信息</td>
        </tr>
        <% ArrayList<Product> productList = (ArrayList<Product>)application.getAttribute("productList");
        for (Product product : productList){ %>
        <tr>
            <td><%=product.getId()%></td>
            <td><%=product.getName()%></td>
            <td><%=product.getPrice()%></td>
            <td><%=product.getStock()%></td>
            <td><%=product.getType()%></td>
            <td><a href="viewProductDetails?id=<%=product.getId()%>">详细信息</a> </td>
        </tr>

        <% } %>
        <tr>
            <td colspan="5"><a href="/showCart.jsp">查看购物车</a> </td>
        </tr>
    </table>
</center>
</body>
</html>
