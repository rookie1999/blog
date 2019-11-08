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
        String s = (String) session.getAttribute("uname");
        if (s == null) {
            response.sendRedirect("/myBlog/login.jsp");
        }
        ServletContext servletContext = getServletConfig().getServletContext();
        int num = Integer.parseInt((String) servletContext.getAttribute("count"));
        num++;
        servletContext.setAttribute("count", num + "");
    %>
    <script>
        function logout() {
            document.logout1.action="/myBlog/logout";
            document.logout1.submit();
        }
    </script>
    <h3>My Blog Space</h3>
    <hr />
    <h5>&nbsp;&nbsp;欢迎<%= s %></h5>
    <p>当前网页浏览次数为：<%=num%></p>
    <form action="" name="logout1" method="get" >
    <input type="submit" onclick="logout()" alian="right" value="注销"/>
    </form>
</body>
</html>
