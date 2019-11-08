package cn.zhanguozhi.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 * @author zhanguozhi
 * @date 2019.11.5
 * @desc 数据库连接池，需要对数据库操作之前都从连接池中获取并释放连接
 */
public class DBConnector {

    private static final int MIN_CONN = 2;
    private static final int MAX_CONN = 5;
    private static final int NORM_CONN = 3;
    private static int CREATE_CONN = 3;
    private static final String url = "jdbc:mysql://localhost:3306/blog?serverTimezone=GMT%2B8&characterEncoding=utf-8 ";

    public static ArrayList<Connection> conns = new ArrayList<>(NORM_CONN);

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            for (int i = 0; i < NORM_CONN; i++) {
                Connection conn = DriverManager.getConnection(url, "root", "123456");
                conns.add(conn);
            }
        } catch (Exception e) {
            System.out.println("初始化失败");
        }
    }

    public static Connection getConnection() {
        if (conns.isEmpty()) {
            if (CREATE_CONN <= MAX_CONN) {
                try {
                    CREATE_CONN++;
                    return DriverManager.getConnection(url, "root", "123456");
                } catch (Exception e) {
                    CREATE_CONN--;
                    System.out.println("创建额外的连接失败");
                }
            } else {
                System.out.println("连接已达最大数 请等待资源释放");
            }
        } else {
            return conns.remove(0);
        }
        return null;
    }

    public static void close(Connection connection) {
        if (CREATE_CONN >= NORM_CONN) {
            try {
                CREATE_CONN--;
                connection.close();
            } catch (Exception e) {
                CREATE_CONN++;
                System.out.println("释放资源失败");
                throw new RuntimeException();
            }
        } else {
            conns.add(connection);
        }
    }

}
