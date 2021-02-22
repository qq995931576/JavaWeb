<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PePe
  Date: 2020/11/27
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 1、遍历1到10，输出结果
    begin属性设置开始的索引
    end属性设置结束的索引
    var属性表示循环的变量（也表示当前正在遍历到的数据）

    for(int i = 1;i < 100; i++)

--%>
<c:forEach begin="1" end="10" var="i">
    <h1>${ i }</h1>
</c:forEach>
<form action="" enctype="multipart/form-data" input type></form>
</body>
</html>
