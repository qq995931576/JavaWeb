<%@ page import="org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID" %><%--
  Created by IntelliJ IDEA.
  User: PePe
  Date: 2020/12/2
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object user = session.getAttribute("user");

    //如果等于null，则还没有登录
    if (user == null) {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
        return;
    }

%>
我是a.jsp文件
</body>
</html>
