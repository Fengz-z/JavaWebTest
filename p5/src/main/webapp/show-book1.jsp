<%@ page import="com.demo.entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: SiriFeng
  Date: 2020/11/10 0010
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Book book = (Book) request.getAttribute("book");
%>
<table>
    <tr>
        <td style="width: 80px">图书编号</td>
        <td style="width: 80px">图书名称</td>
        <td style="width: 80px">图书价格</td>
    </tr>
    <tr>
    <tr>
        <td><%=book.getIsbn()%></td>
        <td><%=book.getTitle()%></td>
        <td><%=(double)book.getPrice()%></td>
    </tr>
</table>
</body>
</html>
