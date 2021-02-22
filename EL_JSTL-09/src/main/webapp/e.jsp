<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID" %><%--
  Created by IntelliJ IDEA.
  User: PePe
  Date: 2020/11/27
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //        1、值为null时，为空
    request.setAttribute("emptyNull", null);
//        2、值为空串，为空
    request.setAttribute("emptyStr", "");
//        3、值是Object类型数组，长度为0时
    request.setAttribute("emptyObj", new Object[0]);
//        4、List集合，元素个数为0
    List<String> list = new ArrayList<>();
    request.setAttribute("emptyList", list);
//        5、map集合，元素个数为0
    HashMap<String, Integer> map = new HashMap<>();
    request.setAttribute("emptyMap", map);
%>
<hr>
//分割线
${ empty emptyNull} <br>
${ empty emptyStr} <br>
${ empty emptyObj} <br>
${ empty emptyList} <br>
${ empty emptyMap} <br>
<hr>
<br>
${ 12 == 12 ? "阿昌加油" : "阿昌冲冲冲" }


</body>
</html>
