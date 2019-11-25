<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start to Login</title>
</head>
<body>
    <form action="/myBlog/login" method="post">
        username:<input type="text" name="uname" /><br />
        password:<input type="password" name="pwd" /><br />
        <input type="submit" value="submit" />
    </form>
</body>
</html>