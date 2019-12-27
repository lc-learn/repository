<%--
  Created by IntelliJ IDEA.
  User: L丶C
  Date: 2019/12/24
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    function back(){
        window.location.href="/User/queryUserByPage";
        //alert("当前页面:"${page.currentPage})
    }
</script>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
    <div align="center">
        <form action="/User/updateUser" method="post" >
            ID：<input name="id" type="text" value="${user.id}" readonly="readonly" required="required" /><br/>
            用户名：<input name="userName" type="text" value="${user.userName}" required="required"/><br/>
            密码：<input name="password" type="text" value="${user.password}" required="required"/><br/>
            姓名：<input name="name" type="text" value="${user.name}" required="required"/><br/>
            年龄：<input name="age" type="text" value="${user.age}" required="required"/><br/>
            <%--<input name="sex" type="hidden" value="${user.sex}"/>--%>
            性别：<select name="sex" required="required">
                    <option value="男" <c:if test="${user.sex=='男'}">selected="selected"</c:if>>男</option>
                    <option value="女" <c:if test="${user.sex=='女'}">selected="selected"</c:if>>女</option>
                </select><br><br>
            <input type="submit" value="修改"/>
            <input type="button" onclick="back()" value="返回"/>
        </form>
        <%--<a href="/User/queryUserByPage">返回</a>--%>
    </div>
</body>
</html>
