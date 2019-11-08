package cn.zhanguozhi.controller;

import cn.zhanguozhi.domain.UserVo;
import cn.zhanguozhi.service.ILoginService;
import cn.zhanguozhi.utils.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author zhanguozhi
 * @date 2019.11.5
 * @desc 对于用户登录的请求处理  调用service层的ILoginService
 */
public class LoginServlet extends HttpServlet {
    /**
     *
     * 返回一个VO对象，用于进一步对view层做渲染,如果用户不存在，可能为空
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //设置session的参数
        HttpSession session = req.getSession();
        session.setAttribute("uname", uname);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        ILoginService loginService = (ILoginService) applicationContext.getBean("loginService");
        UserVo user = loginService.checkUserLogin(uname, pwd, resp);

    }
}
