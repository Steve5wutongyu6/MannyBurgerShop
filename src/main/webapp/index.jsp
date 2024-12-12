<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/11
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到曼尼汉堡店！</title>
</head>
<body>
<h1>请稍后，正在跳转</h1>
<%
    // 延迟5s
    Thread.sleep(5000);
    response.sendRedirect("login.jsp");
%>
</body>
</html>
