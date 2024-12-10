<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/10
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>所有产品</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/maincss1.css">
</head>
<body>

<div class="container">
    <div class="header">
        <h1>所有产品</h1>
    </div>
    <div class="menu-tabs">
        <button class="<c:if test='${activeCid == 1}'>active</c:if>"
                onclick="location.href='SelectAllProductByPidAndCidServlet?cid=1'">汉堡
        </button>
        <button class="<c:if test='${activeCid == 2}'>active</c:if>"
                onclick="location.href='SelectAllProductByPidAndCidServlet?cid=2'">鸡翅
        </button>
        <button class="<c:if test='${activeCid == 3}'>active</c:if>"
                onclick="location.href='SelectAllProductByPidAndCidServlet?cid=3'">薯条
        </button>
        <button class="<c:if test='${activeCid == 4}'>active</c:if>"
                onclick="location.href='SelectAllProductByPidAndCidServlet?cid=4'">饮料
        </button>
    </div>
    <div class="menu-items">
        <c:forEach var="product" items="${products}">
            <div class="menu-item">
                <img src="${product.pimage}" alt="${product.pname}">
                <h3><a href="ProductDetailServlet?pid=${product.pid}">${product.pname}</a></h3>
            </div>
        </c:forEach>
    </div>
    <div class="pagination">
        <c:if test="${pageNo > 1}">
            <a href="SelectAllProductByPidAndCidServlet?cid=${activeCid}&pageNo=${pageNo - 1}">上一页</a>
        </c:if>
        <span>第 ${pageNo} 页 / 共 ${totalPages} 页</span>
        <c:if test="${pageNo < totalPages}">
            <a href="SelectAllProductByPidAndCidServlet?cid=${activeCid}&pageNo=${pageNo + 1}">下一页</a>
        </c:if>
    </div>
</div>

</body>
</html>
