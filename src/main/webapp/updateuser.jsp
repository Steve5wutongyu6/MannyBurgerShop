<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/9
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册/修改</title>
    <link rel="stylesheet" type="text/css" href="css/registercss.css">
</head>
<body>
<c:set var="user" value="${user}" scope="request"/>
<form action="updateUser" method="post" enctype="multipart/form-data">
    <h2>${empty user ? '用户注册' : '用户信息修改'}</h2>
    用户名: <input type="text" name="username" value="${user.username}" required><br/>
    密码: <input type="password" name="password" value="${user.password}" required><br/>
    姓名: <input type="text" name="name" value="${user.name}" required><br/>
    邮箱: <input type="email" name="email" value="${user.email}" required><br/>
    电话: <input type="text" name="telephone" value="${user.telephone}" required><br/>
    生日: <input type="date" name="birthday" value="${user.birthday}" required><br/>
    性别:
    <input type="radio" name="sex" value="1" ${user.sex == '1' ? 'checked' : ''}>男
    <input type="radio" name="sex" value="0" ${user.sex == '0' ? 'checked' : ''}>女<br/>
    头像: <input type="file" name="photo"><br/>
    <c:if test="${not empty user.photo}">
        <img src="${user.photo}" alt="用户头像" width="100" height="100"><br/>
    </c:if>
    <input type="submit" value="${empty user ? '注册' : '修改'}">
</form>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
</body>
</html>