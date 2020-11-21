<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/13 0013
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sirifeng.Product" %>
<html>
<head>
    <title>显示商品详细信息</title>

</head>

<script type="text/javascript">
    var check = function(){
    var form = document.forms[0];
    if(form.quantity.value==""){
    alert("数量不能为空");
    form.quantity.focus();
    return false;
    }
    }
</script>
<body>
<%
    Product product = (Product) session.getAttribute("product");
%>
<p>商品详细信息</p>
<form name="myform" method="post" action="addToCart" onsubmit="return check(this)">
    <input type="hidden" name="id" value="<%=product.getId()%>">
    <table>
        <tr>
            <td>商品名：</td><td><%=product.getName()%></td>
        </tr>
        <tr>
            <td>说明：</td><td><%=product.getType()%></td>
        </tr>
        <tr>
            <td>价格：</td><td><%=product.getPrice()%></td>
        </tr>
        <tr>
            <td>库存：</td><td><%=product.getStock()%></td>
        </tr>
        <tr>
            <td>
                <input type="text" name="quantity" id="quantity">
                <input type="submit" value="放入购物车" >
            </td>
        </tr>
        <tr><td colspan="2"><a href="index.jsp">显示商品列表</a> </td> </tr>
    </table>
</form>

</body>
</html>
