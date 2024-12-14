<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/14
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单完成</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        h1 {
            color: green;
        }
        p {
            font-size: 18px;
        }
    </style>
</head>
<body>
<h1>订单完成！</h1>
<p>你的取餐号码是：<strong>${listid}</strong></p>
<span>${item}</span>
<p>取餐时请出示取餐号码。</p>
<a href="SelectAllProductByPidAndCidServlet">继续点餐</a>
<a href="MenuServlet">返回主页</a>
</body>
</html>