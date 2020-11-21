<%--
  Created by IntelliJ IDEA.
  User: SiriFeng
  Date: 2020/10/26 0026
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>会话信息</title>
</head>
<body>
<%
    out.println("会话状态："+(session.isNew()?"新会话":"旧会话")+"<br>");
    out.println("会话ID："+session.getId()+"<br>");
    out.println("创建时间："+session.getCreationTime()+"<br>");
    out.println("最近访问时间："+session.getLastAccessedTime()+"<br>");
    out.println("Cookie："+request.getHeader("cookie")+"<br>");
    out.println("现在时间：" +session.getAttribute("time")+"<br>");

%>
</body>
</html>
