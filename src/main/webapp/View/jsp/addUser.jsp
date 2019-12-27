<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: L丶C
  Date: 2019/12/24
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户信息</title>
</head>
<body>
    <div align="center">
        <form action="/User/addUser" method="post">
            用户名：<input name="userName" type="text" value="" required="required"><br/>
            密码：<input name="password" type="text" value="" required="required"><br/>
            姓名：<input name="name" type="text" value="" required="required"><br/>
            年龄：<input name="age" type="text" value="" required="required"><br/>
            性别：<select name="sex" required="required">
            <%--<option value="">未选择</option>--%>
                <option value="男">男</option>
                <option value="女">女</option>
                </select><br><br>
            <input type="submit" value="增加">
            <input type="reset" value="重置">
        </form>
    </div>

</body>
</html>
