<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/9
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>菜单</title>
    <link rel="stylesheet" type="text/css" href="css/tablecss.css">
</head>
<body>
<h1>菜单</h1>
<table border="1">
    <tr>
        <th>序号</th>
        <th>品名</th>
        <th>原价</th>
        <th>优惠价</th>
        <th>图片</th>
        <th>上架日期</th>
        <th>热卖中</th>
        <th>详情</th>
        <th>Flag</th>
        <th>产品类别</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.pid}</td>
            <td>${product.pname}</td>
            <td>${product.marketPrice}</td>
            <td>${product.shopPrice}</td>
            <td><img src="${product.pimage}" width="100"></td>
            <td>${product.pdate}</td>
            <td>${product.isHot == 1 ? 'Yes' : 'No'}</td>
            <td>${product.pdesc}</td>
            <td>${product.pflag}</td>
            <td>${product.cid}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
