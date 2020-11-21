<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/21 0021
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>添加图书信息</title>
</head>
<body>
<p>请输入图书信息</p>
${message}<br>
<form action="addBookServlet" method="post">
    书号：<input type="text" name="isbn"><br>
    书名：<input type="text" name="title"><br>
    价格：<input type="text" name="price"><br>
    <input type="submit" value="确定"><input type="reset" value="重置">
    <a href="/findAll">显示所有图书</a>
    <a href="find-book.jsp">查找图书</a>
</form>
</body>
</html>
