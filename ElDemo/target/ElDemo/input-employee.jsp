<%--
  Created by IntelliJ IDEA.
  User: 12242
  Date: 2020/11/9
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输入员工信息</title>
</head>
<body>
    输入员工信息
    <form action="show-employee"  method="post">
        <table>
            <tr>
                <td>员工号:</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age"></td>
            </tr>
        </table>
        <input type="submit"value="提交">
    </form>

</body>
</html>
