package cn.zhanguozhi.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author zhanguozhi
 * @date 2019.11.25
 * @desc  使用监听器 服务器启动时 根据session显示当前在线人数
 */
public class NumberListener implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("currentOnlinePeople", 0);
        System.out.println("服务器启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().removeAttribute("currentOnlinePeople");
        System.out.println("服务器关闭");
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        int num = (int)servletContext.getAttribute("currentOnlinePeople");
        servletContext.setAttribute("currentOnlinePeople", ++num);
        System.out.println(num);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        int num = (int)servletContext.getAttribute("currentOnlinePeople");
        servletContext.setAttribute("currentOnlinePeople", --num);
        System.out.println(num);
    }
}
