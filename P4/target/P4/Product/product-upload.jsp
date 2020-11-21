<%--
  Created by IntelliJ IDEA.
  User: SiriFeng
  Date: 2020/10/26 0026
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品上传</title>
</head>
<body>
<p>商品上传</p>
<form action="ProductUploadServlet" enctype="multipart/form-data" method="post">
    <label>商品号：<input type="text" name="id"></label><br>
    <label>商品名：<input type="text" name="name"></label><br>
    <label>价格：<input type="text" name="price"></label><br>
    <label>图片：<input type="file" name="photo"></label><br>
    <label><input type="submit" value="提交"></label>
</form>
</body>
</html>
