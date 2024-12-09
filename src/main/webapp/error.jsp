<%--
  Created by IntelliJ IDEA.
  User: Steve
  Date: 2024/12/9
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<!-- 文件路径：src/main/webapp/error.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h2>An error occurred:</h2>
    <p><strong>Status Code:</strong> ${statusCode}</p>
    <p><strong>Requested URI:</strong> ${requestUri}</p>
    <p><strong>Servlet Name:</strong> ${servletName}</p>
    <p><strong>Exception Message:</strong> ${throwable.message}</p>
    <p><strong>Stack Trace:</strong></p>
    <pre>${throwable.stackTrace}</pre>
</body>
</html>

