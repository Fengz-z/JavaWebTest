<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/26 0026
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
${message}<br>
<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td colspan="2" align="center">文件上传</td>
        </tr>
        <tr>
            <td>会员号：</td>
            <td><input type="text" name="mnumber" size="30"></td>
        </tr>
        <tr>
            <td>文件名：</td>
            <td><input type="file" name="filename" size="30"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
