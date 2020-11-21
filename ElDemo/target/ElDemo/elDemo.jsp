<%--
  Created by IntelliJ IDEA.
  User: 12242
  Date: 2020/11/9
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>title</title>
</head>
<body>
<h1>jsp 2.0表达式语言.基本算术运算符</h1>
<hr>
  该例说明了基本表达式语言的算术运算符的使用，加减乘除
  <br>
<table border=" 1">
    <tr>
        <td><b>\${1+2}</b></td>
        <td><b>${1+2}</b></td>
    </tr>
    <tr>
        <td><b>\${1.2+2.3}</b></td>
        <td><b>${1.2+2.3}</b></td>
    </tr>
    <tr>
        <td><b>\${1.2E4+1.4}</b></td>
        <td><b>${1.2E4+1.4}</b></td>
    </tr>
    <tr>
        <td><b>\${-4-2}</b></td>
        <td><b>${-4-2}</b></td>
    </tr>
    <tr>
        <td><b>\${21*2}</b></td>
        <td><b>${21*2}</b></td>
    </tr>
    <tr>
        <td><b>\${3/4}</b></td>
        <td><b>${3/4}</b></td>
    </tr>
    <tr>
        <td><b>\${3/0}</b></td>
        <td><b>${3/0}</b></td>
    </tr>
    <tr>
        <td><b>\${10%4}</b></td>
        <td><b>${10%4}</b></td>
    </tr>
    <tr>
    <td><b>\${10 mod 4}</b></td>
    <td><b>${10 mod 4}</b></td>
    </tr>
    <tr>
        <td><b>\${(1==2)?3:4}</b></td>
        <td><b>${(1==2)?3:4}</b></td>
    </tr>

</body>
</html>
