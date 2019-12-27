<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: L丶C
  Date: 2019/12/24
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>用户登录</h1>
    <form action="/User/check" method="post">
        用户名：<input name="userName" type="text" value=""><br/>
        密码：<input name="password" type="password" value=""><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
