<%--
  Created by IntelliJ IDEA.
  User: PePe
  Date: 2020/11/27
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/EL_JSTL_09/uploadServlet" enctype="multipart/form-data" method="post">
    用户名：<input type="text" name="username"> <br>
    头 像：<input type="file" name="photo">
    <input type="submit" value="上传">
</form>
</body>
</html>
