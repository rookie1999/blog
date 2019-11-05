package cn.zhanguozhi.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {
    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    private SpringContext() {

    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
