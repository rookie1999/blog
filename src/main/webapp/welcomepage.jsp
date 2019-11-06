<%--
  Created by IntelliJ IDEA.
  User: zhanguozhi
  Date: 2019/11/5
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <%
        String s = "您";
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if (cookies != null) {
            for(Cookie c : cookies) {
                if ("uname".equals(c.getName())) {
                    cookie = c;
                    s = c.getValue();
                    break;
                }
            }
        }
    %>
    <script>
        function logout() {
            document.logout1.action="/myBlog/logout";
            document.logout1.submit();
        }
    </script>
    <h3>My Blog Space</h3>
    <hr />
    <b>登录成功</b>
    <h5>&nbsp;&nbsp;欢迎<%= s %></h5>
    <form action="" name="logout1" method="get" >
    <input type="submit" onclick="logout()" alian="right" value="注销"/>
    </form>
</body>
</html>
