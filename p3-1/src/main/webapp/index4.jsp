<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/12 0012
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>站点首页面</title>
    <link href="css\layout.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">
    <div id="header"><%@ include file="header4.jsp"%></div>
    <br>
    <div id="topmenu"><%@ include file="topmenu4.jsp"%></div>
    <div id="mainContent">
        <div id="leftmenu"><%@ include file="leftmenu4.jsp"%></div>
        <div id="content"><%@ include file="content4.jsp"%></div>
    </div>
    <div id="footer"><%@ include file="footer4.jsp"%></div>
</div>
</body>
</html>