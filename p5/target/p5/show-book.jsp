<%@ page import="com.demo.entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: SiriFeng
  Date: 2020/11/7 0007
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <td style="width: 80px">图书编号</td>
        <td style="width: 80px">图书名称</td>
        <td style="width: 80px">图书价格</td>
        <td style="width: 80px">删除图书</td>
    </tr>
    <%
        ArrayList<Book> books = (ArrayList<Book>) request.getAttribute("books");
        for (Book book :books){

    %>

    <tr>
        <td><%=book.getIsbn()%></td>
        <td><%=book.getTitle()%></td>
        <td><%=(double)book.getPrice()%></td>
        <td><a href="deleteBookServlet?isbn=<%=book.getIsbn()%>">删除</a></td>
    </tr>

    <%
        }
    %>
    <tr>
        <td><a href="add-book.jsp">添加图书</a></td>
    </tr>
</table>
</body>
</html>
