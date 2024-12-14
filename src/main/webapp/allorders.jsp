<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/14
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有订单</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        a {
            text-decoration: none;
            color: blue;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>所有订单</h1>
<table>
    <thead>
    <tr>
        <th>订单ID</th>
        <th>用户ID</th>
        <th>下单时间</th>
        <th>商品信息</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="olist" items="${olist}">
        <tr>
            <td>${olist.listid}</td>
            <td>${olist.uid}</td>
            <td>${olist.time}</td>
            <td>${olist.item}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="MenuServlet">返回主页</a>
</body>
</html>
