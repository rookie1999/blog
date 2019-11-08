package cn.zhanguozhi.controller;

import cn.zhanguozhi.domain.UserVo;
import cn.zhanguozhi.service.IRegisterService;
import cn.zhanguozhi.utils.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhanguozhi
 * @date 2019.11.5
 * @desc 注册新账户 返回VO对象(可能为null)做进一步view层渲染
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //设置响应编码
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        IRegisterService registerService = (IRegisterService) applicationContext.getBean("registerService");
        UserVo uservo = registerService.registerNewAccount(uname, pwd, email, resp);
    }
}
