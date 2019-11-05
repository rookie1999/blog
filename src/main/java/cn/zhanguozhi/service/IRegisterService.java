package cn.zhanguozhi.service;

import cn.zhanguozhi.domain.UserVo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IRegisterService {
    UserVo registerNewAccount(String username, String password, String email, HttpServletResponse resp) throws IOException;
}
