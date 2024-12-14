<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/9
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/maincss.css">
</head>
<body>

<div class="container">
    <div class="header">
        <h1>商品详情</h1>
    </div>
    <div class="product-detail">
        <c:set var="product" value="${product}"/>
        <img src="${product.pimage}" alt="${product.pname}">
        <h2>${product.pname}</h2>
        <p>市场价: ${product.marketPrice}</p>
        <p>现价: ${product.shopPrice}</p>
        <p>描述: ${product.pdesc}</p>
        <form action="AddToCartServlet" method="post">
            <input type="hidden" name="pid" value="${product.pid}">
            <input type="hidden" name="uid" value="${sessionScope.user.uid}"> <!-- 假设用户ID存储在session中 -->
            <label for="count">数量:</label>
            <input type="number" id="count" name="count" value="1" min="1"> <!-- 添加 count 输入字段 -->
            <button type="submit">加入购物车</button>
        </form>
        <a href="/SelectAllProductByPidAndCidServlet">返回菜单</a>
    </div>
</div>

</body>
</html>


</body>
</html>
