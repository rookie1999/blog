package cn.zhanguozhi.controller;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.*;

/**
 * @author zhanguozhi
 * @date 2019.11.8
 * @desc 用来在服务器启动的时候加载全局配置
 *       在服务器关闭的时候保存全局配置
 */
public class ConfigServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(servletContext.getRealPath("/config/count.txt"));
            System.out.println(servletContext.getRealPath("/config/count.txt"));
            bufferedReader = new BufferedReader(fileReader);
            String num = bufferedReader.readLine();
            if (num == null) {
                num = "0";
            }
            servletContext.setAttribute("count", num);
        } catch (Exception e) {
            throw new RuntimeException("初始化全局配置失败");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException("初始化配置失败");
            }
        }

    }

    @Override
    public void destroy() {
        ServletContext servletContext = getServletContext();
        String num = (String) servletContext.getAttribute("count");
        System.out.println(num);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(servletContext.getRealPath("/config/count.txt"));
            System.out.println(servletContext.getRealPath("/config/count.txt"));
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(num + "");
            bufferedWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException("保存全局配置失败");
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException("保存全局配置失败");
            }
        }
    }
}
