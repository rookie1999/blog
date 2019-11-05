<%--
  Created by IntelliJ IDEA.
  User: zhanguozhi
  Date: 2019/11/5
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start to Register</title>
</head>
<body>
    <form action="/myBlog/register" method="post">
        username:<input type="text" name="uname" /><br />
        password:<input type="password" name="pwd" /><br />
        email:<input type="email" name="email" /><br />
        <input type="submit" value="submit" />
    </form>
</body>
</html>
