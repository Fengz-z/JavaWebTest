<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<table>
    <tr style="background:#448755;color:white;font-weight:bold">
        <td>国家</td>
        <td>首都</td>
    </tr>
    <c:forEach items="${requestScope.capitals}" var="mapItem">
        <tr>
            <td>${mapItem.key}</td>
            <td>${mapItem.value}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<table>
    <tr style="background:#448755;color;white;font-weight：bold">
        <td>国家</td>
        <td>城市</td>
    </tr>
    <c:forEach items="${requestScope.bigCities }" var="mapItem">
        <tr>
            <td>${mapItem.key}</td>
            <td>

                <c:forEach items="${mapItem.value}" var="city" varStatus="status">
                    ${city}<c:if test="${!status.last} ">,</c:if>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>