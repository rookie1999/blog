package cn.zhanguozhi.dao;

import cn.zhanguozhi.domain.UserInfo;

public interface UserDao {
    //注册账号
    UserInfo addUser(String username, String password, String email);
    //删除账号
    void deleteUser(String username, String password);
    //获取账号  一般用作登录验证
    UserInfo getUserByName(String username);
    //更改账号密码
    UserInfo updateUserPassword(String username, String password);
    //更改账号邮箱
    UserInfo updateUserEmail(String username, String email);
    //更改账号最后一次登录时间
    UserInfo updateUserLastLoginTime(String username, String password);
}
