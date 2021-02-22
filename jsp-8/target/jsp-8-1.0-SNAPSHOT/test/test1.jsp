<%--
  Created by IntelliJ IDEA.
  User: PePe
  Date: 2020/11/26
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--在 jsp页面中输出九九乘法口诀表--%>
<%
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= i; j++) {
%>
<% j + "X" + i + "=" + (i * j) %>
<%
    }
<%
    <br / >
%>
}

%>

</body>
</html>
