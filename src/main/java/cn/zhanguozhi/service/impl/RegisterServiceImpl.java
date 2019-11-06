package cn.zhanguozhi.service.impl;

import cn.zhanguozhi.dao.UserDao;
import cn.zhanguozhi.domain.UserInfo;
import cn.zhanguozhi.domain.UserVo;
import cn.zhanguozhi.service.IRegisterService;
import cn.zhanguozhi.utils.SpringContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service("registerService")
public class RegisterServiceImpl implements IRegisterService {
    @Override
    public UserVo registerNewAccount(String username, String password, String email, HttpServletResponse resp) throws IOException {
        ApplicationContext applicationContext = SpringContext.getApplicationContext();
        UserDao loginDao = (UserDao) applicationContext.getBean("userDao");
        UserInfo user = loginDao.addUser(username, password, email);
        if (user == null) { //用户已存在
            resp.getWriter().write("注册失败，用户名已存在<br />");
            resp.getWriter().write("3秒后回到初始页面...");
            resp.setHeader("refresh", "3;/myBlog/index.jsp");
        } else {
            resp.getWriter().write("注册成功，页面将在3秒后跳转...");
            resp.setHeader("refresh", "3;/myBlog/login.jsp");
            UserVo userVo = new UserVo();
            userVo.setUsername(user.getUsername());
            userVo.setPassword(user.getPassword());
            userVo.setEmail(user.getEmail());
            return userVo;
        }
        return null;
    }
}
