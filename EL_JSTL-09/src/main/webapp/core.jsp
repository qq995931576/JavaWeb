<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PePe
  Date: 2020/11/27
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
保存之前：${ requestScope.abc }<br>
<c:set scope="request" var="abc" value="123"/>
保存之后：${ requestScope.abc }<br>
<hr>
<c:if test="${ 12 == 12 }">
    <h1>12等于12</h1>
</c:if>
<hr>
<%
    request.setAttribute("height", 178);
%>
<c:choose>
    <c:when test="${ requestScope.height >190}">
        <h1>小巨人</h1>
    </c:when>
    <c:when test="${ requestScope.height>180 }">
        <h1>很高</h1>
    </c:when>
    <c:when test="${ requestScope.height>170 }">
        <h1>还可以</h1>
    </c:when>
    <c:otherwise>
        <h1>剩下小于170情况</h1>
    </c:otherwise>
</c:choose>

</body>
</html>
