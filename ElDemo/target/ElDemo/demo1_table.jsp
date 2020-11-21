<%@ page import="com.sirifeng.entity.Employee" %>
<%--
  Created by IntelliJ IDEA.
  User: SiriFeng
  Date: 2020/11/11 0011
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>jsp 2.0表达式语言.使用EL访问数据</h1>
<hr>
获取数组数据、获取List数据、获取Map数据、获取对象数据、获取对象的集合数据
<hr>
表1 获取数组数据
<table border="1">
    <tr>
        <td><b>EL表达式</b></td>
        <td><b>结果</b></td>
    </tr>
    <tr>
        <td>arrs[0]</td>
        <td>${arrs[0]}</td>
    </tr>
    <tr>
        <td>arrs[1]</td>
        <td>${arrs[1]}</td>
    </tr>
    <tr>
        <td>arrs[2]</td>
        <td>${arrs[2]}</td>
    </tr>
    <tr>
        <td>arrs[3]</td>
        <td>${arrs[3]}</td>
    </tr>
</table>
<hr>
表2 获取list数据
<table border="1">
    <tr>
        <td><b>EL表达式</b></td>
        <td><b>结果</b></td>
    </tr>
    <tr>
        <td>list[0]</td>
        <td>${list[0]}</td>
    </tr>
    <tr>
        <td>list[1]</td>
        <td>${list[1]}</td>
    </tr>
    <tr>
        <td>list[2]</td>
        <td>${list[2]}</td>
    </tr>
    <tr>
        <td>list[3]</td>
        <td>${list[3]}</td>
    </tr>
</table>
<hr>
表3 获取Map集合数据
<table border="1">
    <tr>
        <td><b>EL表达式</b></td>
        <td><b>结果</b></td>
    </tr>
    <tr>
        <td>map.a</td>
        <td>${map.a}</td>
    </tr>
    <tr>
        <td>map.b</td>
        <td>${map.b}</td>
    </tr>
    <tr>
        <td>map.c</td>
        <td>${map.c}</td>
    </tr>
    <tr>
        <td>map.d</td>
        <td>${map.d}</td>
    </tr>
</table>
<hr>
表4 获取对象的数据
<table border="1">
    <tr>
        <td><b>EL表达式</b></td>
        <td><b>结果</b></td>
    </tr>
    <tr>
        <td>user.id</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td>user.username</td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td>user.password</td>
        <td>${user.password}</td>
    </tr>
</table>
<hr>
表5 获取对象的集合的数据
<table border="1">
    <tr>
        <td><b>EL表达式</b></td>
        <td><b>结果</b></td>
    </tr>
    <tr>
        <td>user1</td>
        <td>${empMap.user1.id}-${empMap.user1.username}-${empMap.user1.password}</td>
    </tr>
    <tr>
        <td>user2</td>
        <td>${empMap.user2.id}-${empMap.user2.username}-${empMap.user2.password}</td>
    </tr>
    <tr>
        <td>user3</td>
        <td>${empMap.user3.id}-${empMap.user3.username}-${empMap.user3.password}</td>
    </tr>
</table>
</body>
</html>