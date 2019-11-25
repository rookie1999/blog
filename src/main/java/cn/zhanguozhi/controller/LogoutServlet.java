package cn.zhanguozhi.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhanguozhi
 * @date 2019.11.6
 * @desc 对用户进行注销
 */
public class LogoutServlet extends HttpServlet {

    /**
     *将生成的cookie覆盖掉
     * 页面重定向至index.jsp
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/myBlog/index.jsp");
    }
}
