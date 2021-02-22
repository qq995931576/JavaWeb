<%--
  Created by IntelliJ IDEA.
  User: PePe
  Date: 2020/11/27
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        22
    </title>
</head>
<body>
<%
    pageContext.setAttribute("key1", "pageContext1");
    pageContext.setAttribute("key2", "pageContext2");
    request.setAttribute("key2", "request");
    session.setAttribute("key2", "session");
    application.setAttribute("key2", "application");

%>
${ sessionScope.key2 }


</body>
</html>
