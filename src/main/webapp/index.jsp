<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script>
    function regist() {
        document.welcome.action="register.jsp";
        document.welcome.submit();
    }
</script>
<c:if test="${!(empty user) && user.username != null}">
    <% response.sendRedirect("/myBlog/welcomePage.jsp");%>
</c:if>
<form action="" name="welcome" method="post">
    <button onclick="regist()" name="register">Register</button>
    <button onclick="login()" name="log in">Log in</button>
</form>
</body>
</html>
