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
    </style>
</head>
<body>
<div class="metro-menu">
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/SelectAllProductByPidAndCidServlet">选择菜品</a>
    </div>
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/SelectItemsInCartServlet?uid=1">购物车</a>
    </div>
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/updateUser?username=user1">修改用户信息</a>
    </div>
    <div class="metro-tile">
        <a href="${pageContext.request.contextPath}/SelectProductByCidServlet">热门推荐</a>
    </div>
</div>
</body>
</html>