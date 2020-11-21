<%--
  Created by IntelliJ IDEA.
  User: SiriFeng
  Date: 2020/11/3 0003
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品上传</title>
</head>
<body>
<form action="ProductUploadServlet" enctype="multipart/form-data" method="post">
    <label>商品号：<input type="text" name="id"><br></label>
    <label>商品名：<input type="text" name="name"><br></label>
    <label>价格：<input type="text" name="price"><br></label>
    <label>图片：<input type="file" name="photo"></label>
    <label><input type="submit" value="提交"></label>
</form>
</body>
</html>
