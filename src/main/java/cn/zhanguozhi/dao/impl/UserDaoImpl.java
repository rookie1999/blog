package cn.zhanguozhi.dao.impl;

import cn.zhanguozhi.dao.UserDao;
import cn.zhanguozhi.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public UserInfo addUser(String username, String password, String email) {
        Connection conn = DBConnector.getConnection();
        if (getUserByName(username) != null) {
            System.out.println("用户已存在");
            return null;
        }
        String sql = "insert into user(username, password, email) values (?, ?, ?);";
        UserInfo userInfo = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            if (i == 1) {
                userInfo = new UserInfo();
                userInfo.setUsername(username);
                userInfo.setPassword(password);
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            System.out.println("添加失败");
        } finally {
            DBConnector.close(conn);
        }
        return userInfo;
    }

    @Override
    public void deleteUser(String username, String password) {
        Connection conn = DBConnector.getConnection();
        String sql = "delete from user where username = ?;";
        UserInfo userInfo = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            System.out.println("删除失败");
        } finally {
            DBConnector.close(conn);
        }

    }

    @Override
    public UserInfo getUserByName(String username) {
        Connection conn = DBConnector.getConnection();
        String sql = "select * from user where username = ?;";
        UserInfo userInfo = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                userInfo = new UserInfo(result.getInt("id"), result.getString("username"),
                        result.getString("password"), result.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("查询失败");
        } finally {
            DBConnector.close(conn);
        }
        return userInfo;
    }

    @Override
    public UserInfo updateUserPassword(String username, String password) {
        Connection conn = DBConnector.getConnection();
        String sql = "update user set password = ? where username = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                return getUserByName(username);
            } else {
                System.out.println("修改密码失败");
            }
        } catch (SQLException e) {
            System.out.println("修改密码失败");
        } finally {
            DBConnector.close(conn);
        }
        return null;
    }

    @Override
    public UserInfo updateUserEmail(String username, String email) {
        Connection conn = DBConnector.getConnection();
        String sql = "update user set password = ? where username = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                return getUserByName(username);
            } else {
                System.out.println("修改邮箱失败");
            }
        } catch (SQLException e) {
            System.out.println("修改邮箱失败");
        } finally {
            DBConnector.close(conn);
        }
        return null;
    }
}
