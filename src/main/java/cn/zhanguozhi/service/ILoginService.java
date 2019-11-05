package cn.zhanguozhi.service;

import cn.zhanguozhi.domain.UserInfo;
import cn.zhanguozhi.domain.UserVo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ILoginService {
    UserVo checkUserLogin(String username, String password, HttpServletResponse resp) throws IOException;
}
