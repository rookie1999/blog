<html>
<head>
    <title>BlogSpace</title>
</head>
<body>
<h2>Welcome to blog!</h2>
<script>
    function login() {
        document.welcome.action="login.jsp";
        document.welcome.submit();
    }
</script>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("uname".equals(c.getName()) && !c.getValue().equals("")) {//如果为null  是注销登录的
                response.sendRedirect("/myBlog/welcomepage.jsp");
            }
        }
    }

%>
<script>
    function regist() {
        document.welcome.action="register.jsp";
        document.welcome.submit();
    }
</script>
<form action="" name="welcome" method="post">
    <button onclick="regist()" name="register">Register</button>
    <button onclick="login()" name="log in">Log in</button>
</form>
</body>
</html>
