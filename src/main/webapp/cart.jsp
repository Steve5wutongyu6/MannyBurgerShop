<%@ page import="bean.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/10
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<h1>购物车</h1>
<table border="1">
    <tr>
        <th>商品名称</th>
        <th>市场价</th>
        <th>商城价</th>
        <th>操作</th>
    </tr>
    <%
        List<Product> productList = (List<Product>) request.getAttribute("productList");
        if (productList != null && !productList.isEmpty()) {
            for (Product product : productList) {
    %>
    <tr>
        <td><%= product.getPname() %>
        </td>
        <td><%= product.getMarketPrice() %>
        </td>
        <td><%= product.getShopPrice() %>
        </td>
        <td><a href="RemoveFromCartServlet?pid=<%= product.getPid() %>">移除</a></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="4">购物车为空</td>
    </tr>
    <%
        }
    %>
</table>
<h2>总价: <%= request.getAttribute("totalPrice") %> 元</h2>
<a href="ProductListServlet">继续购物</a>
</body>
</html>
