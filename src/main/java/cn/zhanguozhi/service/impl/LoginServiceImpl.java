package cn.zhanguozhi.service.impl;

import cn.zhanguozhi.dao.UserDao;
import cn.zhanguozhi.domain.UserInfo;
import cn.zhanguozhi.domain.UserVo;
import cn.zhanguozhi.service.ILoginService;
import cn.zhanguozhi.utils.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhanguozhi
 * @date 2019.11.5
 * @desc 调用ILoginDao对用户的输入参数进行验证
 *       并设置response 返回VO对象
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService {
    @Override
    public UserVo checkUserLogin(String username, String password, HttpServletResponse resp) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao loginDao = (UserDao) applicationContext.getBean("userDao");
        UserInfo user = loginDao.updateUserLastLoginTime(username, password);
        System.out.println(user);
        if (user == null || !(user.getPassword().equals(password))) { //没有该用户或者是密码错误
            System.out.println("用户不存在");
            resp.getWriter().write("登录失败，用户名或密码错误<br />");
            resp.getWriter().write("3秒后回到初始页面...");
            resp.setHeader("refresh", "3;/myBlog/index.jsp");
        } else {    //用户存在 可以正常登录
//            resp.getWriter().write("登录成功，页面将在3秒后跳转...");
//            resp.setHeader("refresh", "3;/myBlog/welcomePage.jsp");
            //cookie不建议存储太大的数据  这里使用session存储更好
//            //设置cookie完成一次会话免密登录
//            Cookie c = new Cookie("uname",username);
//            resp.addCookie(c);
            UserVo userVo = new UserVo();
            userVo.setUsername(user.getUsername());
            userVo.setPassword(user.getPassword());
            userVo.setEmail(user.getEmail());
            System.out.println("用户存在");
            return userVo;
        }
        return null;
    }
}
