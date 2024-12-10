
<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/9
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="css/registercss.css">
</head>
<body>
<form action="register" method="post" enctype="multipart/form-data">
    <h2>用户注册</h2>
    用户名: <input type="text" name="username" required><br/>
    密码: <input type="password" name="password" required><br/>
    姓名: <input type="text" name="name" required><br/>
    邮箱: <input type="email" name="email" required><br/>
    电话: <input type="text" name="telephone" required><br/>
    生日: <input type="date" name="birthday" required><br/>
    性别:
    <input type="radio" name="sex" value="1" required>男
    <input type="radio" name="sex" value="0" required>女<br/>
    头像: <input type="file" name="photo"><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>