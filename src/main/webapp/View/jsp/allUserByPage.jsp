<%--
  Created by IntelliJ IDEA.
  User: L丶C
  Date: 2019/12/24
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script>
        /**
         * 添加用户
         */
        function add(){
            window.location.href="/User/toAdd";
        }

        /**
         * 修改页面大小
         */
        function up() {
            var pageSize=document.getElementById("pageSize").value;
            window.location.href="${pageContext.request.contextPath}/User/queryUserByPage?currentPage=1&pageSize="+pageSize;
        }
    </script>
    <title>所有用户信息</title>

</head>
<body>
    <div align="center">
        <h2>所有用户</h2>
        <button onclick="add()">新增</button>
        页面大小 <select id="pageSize" required="required" onchange="up()">
                    <option value="2" <c:if test="${page.pageSize==2}">selected="selected"</c:if>>2</option>
                    <option value="5" <c:if test="${page.pageSize==5}">selected="selected"</c:if>>5</option>
                    <option value="10" <c:if test="${page.pageSize==10}">selected="selected"</c:if>>10</option>
                </select>

        </select>
        <table border="1">
            <tr>
                <th>用户名</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${user}" var="user">
            <tr>
                <th>${user.userName}</th>
                <th>${user.name}</th>
                <th>${user.age}</th>
                <th>${user.sex}</th>
                <th>
                    <%--<button onclick="view(${user.id})">查看</button>--%>
                    <%--<button onclick="del(${user.id})">删除</button>--%>
                    <a href="/User/viewUser/id=${user.id}">查看</a>
                    <a href="/User/deleteUser/id=${user.id}">删除</a>
                </th>
            </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/User/queryUserByPage?currentPage=1&pageSize=${page.pageSize}">首页</a>
        <c:choose>
            <c:when test="${page.currentPage - 1 > 0}">
                <a href="${pageContext.request.contextPath}/User/queryUserByPage?currentPage=${page.currentPage - 1}&pageSize=${page.pageSize}">上一页</a>
            </c:when>
            <c:when test="${page.currentPage - 1 <= 0}">
                <%--<a href="${pageContext.request.contextPath}/User/queryUserByPage?currentPage=1">上一页</a>--%>
                <a>上一页</a>

            </c:when>
        </c:choose>
        ${page.currentPage}/${page.totalPage}
        <c:choose>
            <c:when test="${page.totalPage==0}">
                <a href="${pageContext.request.contextPath}/User/queryUserByPage?currentPage=${page.currentPage}&pageSize=${page.pageSize}">下一页</a>
            </c:when>
            <c:when test="${page.currentPage + 1 <= page.totalPage}">
                <a href="${pageContext.request.contextPath}/User/queryUserByPage?currentPage=${page.currentPage + 1}&pageSize=${page.pageSize}">下一页</a>
            </c:when>
            <%--<c:when test="${page.currentPage + 1 >= page.totalPage}">--%>
                <%--<a href="${pageContext.request.contextPath}/User/queryUserByPage?currentPage=${page.totalPage}">下一页</a>--%>
            <%--</c:when>--%>
            <c:when test="${page.currentPage+1 > page.totalPage}">
                <a>下一页</a>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${page.totalPage==0}">
                <a href="${pageContext.request.contextPath}/User/queryUserByPage?currentPage=${page.currentPage}&pageSize=${page.pageSize}">尾页</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/User/queryUserByPage?currentPage=${page.totalPage}&pageSize=${page.pageSize}">尾页</a>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
