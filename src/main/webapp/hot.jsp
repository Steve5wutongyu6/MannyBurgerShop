<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/9
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>欢迎光临曼尼汉堡店</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/maincss.css">
</head>
<body>

<div class="container">
    <div class="header">
        <h1>热门菜品</h1>
    </div>
    <div class="menu-tabs">
        <button class="<c:if test='${activeCid == 1}'>active</c:if>"
                onclick="location.href='SelectProductByCidServlet?cid=1'">汉堡
        </button>
        <button class="<c:if test='${activeCid == 2}'>active</c:if>"
                onclick="location.href='SelectProductByCidServlet?cid=2'">鸡翅
        </button>
        <button class="<c:if test='${activeCid == 3}'>active</c:if>"
                onclick="location.href='SelectProductByCidServlet?cid=3'">薯条
        </button>
        <button class="<c:if test='${activeCid == 4}'>active</c:if>"
                onclick="location.href='SelectProductByCidServlet?cid=4'">饮料
        </button>
    </div>
    <div class="menu-items">
        <c:forEach var="product" items="${hotProducts}">
            <div class="menu-item">
                <img src="${product.pimage}" alt="${product.pname}">
                <h3><a href="ProductDetailServlet?pid=${product.pid}">${product.pname}</a></h3>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>