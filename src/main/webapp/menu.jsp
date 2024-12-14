<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/11
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主菜单</title>
    <style>
        /* 之前的样式代码 */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .metro-menu {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
            gap: 20px;
            width: 80%;
            max-width: 600px;
        }

        .metro-tile {
            background-color: #00a8e6;
            color: white;
            text-align: center;
            padding: 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .metro-tile:hover {
            background-color: #007acc;
        }

        .metro-tile a {
            color: white;
            text-decoration: none;
            font-size: 18px;
        }

        /* 添加的样式 */
        .header {
            position: fixed;
            top: 0;
            right: 0;
            padding: 10px;
            background-color: rgba(255, 255, 255, 0.8);
            display: flex;
            align-items: center;
        }

        .header img {
            width: 30px;
            height: 30px;
            border-radius: 50%;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<div class="header">
    <img src="${photoPath}" alt="User Photo">
    <span>欢迎光临！${username}</span>
</div>


<div class="metro-menu">
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/SelectAllProductByPidAndCidServlet">选择菜品</a>
    </div>
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/CartServlet">购物车</a>
    </div>
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/updateUser?username=user1">修改用户信息</a>
    </div>
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/SelectProductByCidServlet">热门推荐</a>
    </div>
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/LogOutServlet">登出</a>
    </div>
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/register.jsp">邀请新用户</a>
    </div>
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/AllOrderServlet">我的订单</a>
    </div>
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/ProductListServlet">价目表</a>
    </div>
</div>
</body>
</html>
