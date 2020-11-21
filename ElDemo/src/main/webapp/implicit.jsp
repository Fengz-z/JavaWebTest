<%--
  Created by IntelliJ IDEA.
  User: 12242
  Date: 2020/11/9
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL隐含对象</title>
</head>
<body>
    <p>EL表达式语言-隐含对象</p>
    <hr>
    <p>输入foot参数值</p>
    <form action="implicit.jsp" method="GET">
        foo=<input type="text" name="foo" value="${param['foo']}"/><input
    type="submit"/>

    </form>
    <br>
    <table border="1">
        <tr>
            <td><b>EL 表达式</b></td>
            <td><b>结果</b></td>
        </tr>
        <tr>
            <td>\${param.foo}}</td>
            <td>${param.foo}&nbsp;</td>
        </tr>
        <tr>
            <td>\${param["foo"]}</td>
            <td>${param["foo"]}&nbsp;</td>
        </tr>
        <tr>
            <td>\${header["host"]}}</td>
            <td>${header["host"]}</td>
        </tr>
        <tr>
            <td>\${header["accept"]}}</td>
            <td>${header["accept"]}</td>
        </tr>
        <tr>
            <td>\${header["user-agent"]}}</td>
            <td>${header["user-agent"]}</td>
        </tr>

    </table>

</body>
</html>
