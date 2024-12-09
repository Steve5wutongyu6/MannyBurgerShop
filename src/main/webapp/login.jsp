<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/9
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登陆</title>
    <link rel="stylesheet" type="text/css" href="css/logincss.css">
</head>
<body>

<%
    Cookie[] cookies = request.getCookies();
    String username = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
                break;
            }
        }
    }
%>
<form action="LoginServlet" method="post">
    <h2>登陆</h2>
    Username: <input type="text" name="username"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="checkbox" name="rememberMe"> 记住用户名<br><br>
    <div id="button-group">
        <a href="register.jsp"><input type="button" value="注册"></a>
        <a href="updateuser.jsp"><input type="button" value="找回密码"></a>
    </div>

    <input type="submit" value="Login">
</form>
</body>
</html>