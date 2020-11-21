<%@ page import="com.sirifeng.ShoppingCart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sirifeng.GoodItem" %>
<%@ page import="com.sirifeng.Product" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/13 0013
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户购物车信息</title>
</head>
<body>
<%
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
    ArrayList<GoodItem> items = new ArrayList<GoodItem>(cart.getItems());
%>
<p>您购物车信息</p>
<table>
    <tr>
        <td style="width: 50px">数量</td>
        <td style="width: 80px">商品</td>
        <td style="width: 80px">价格</td>
        <td style="width: 80px">小计</td>
        <td style="width: 80px">是否删除</td>
    </tr>
    <%
    for (GoodItem goodItem : items){
        Product product = goodItem.getProduct();
    %>
    <tr>
        <td><%=goodItem.getQuantity()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=((int)(product.getPrice()*goodItem.getQuantity()*100+0.5))/100.0 %></td>
        <td><a href="deleteItem?id=<%=product.getId()%>">删除</a> </td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="4" style="text-align: right">总计：<%=cart.getTotal()%></td>
    </tr>

</table>
<a href="index.jsp">返回继续购物</a>
</body>
</html>
