<%@ page import="com.achang.bean.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: PePe
  Date: 2020/11/27
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();
    person.setName("阿昌加油");
    person.setPhone(new String[]{"110", "120", "119", "114"});

    ArrayList<String> cities = new ArrayList<>();
    cities.add("温州");
    cities.add("杭州");
    cities.add("嘉兴");
    cities.add("湖州");
    cities.add("衢州");
    person.setCities(cities);

    HashMap<String, Object> map = new HashMap<>();
    map.put("中国", "北京");
    map.put("日本", "东京");
    map.put("美国", "华盛顿");
    map.put("英国", "伦敦");
    person.setMap(map);

    pageContext.setAttribute("person", person);

%>
输出person：${person} <br>
输出person的name属性： ${person.name}<br>
输出person的phone数组属性值： ${person.phone[0]}<br>
输出person的cities集合元素值： ${person.cities}<br>
输出person的cities集合中第一个元素值： ${person.cities[0]}<br>
输出person的map集合： ${person.map}<br>
输出person的map集合中第三个key的值： ${person.map.美国}<br>
输出person的id的值： ${person.id}<br>

</body>
</html>
