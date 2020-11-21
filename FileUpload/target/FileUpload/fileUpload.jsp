<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/15 0015
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
${message}<br>
<form action="/FileUploadServlet" enctype="multipart/form-data" method="post">
    <table>
        <tr><td colspan="2" align="center">文件上传</td></tr>
        <tr>
            <td>会员号：</td>
            <td><input type="text" name="munmber" size="30"></td>
        </tr>
        <tr>
            <td>文件名：</td>
            <td><input type="file" name="fileName" size="30"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" value="提交"></td>
            <td align="left"><input type="reset" value="取消"></td>
        </tr>
    </table>
</form>

</body>
</html>
