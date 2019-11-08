package cn.zhanguozhi.utils;

import cn.zhanguozhi.dao.UserDao;
import cn.zhanguozhi.service.ILoginService;
import cn.zhanguozhi.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanguozhi
 * @date 2019.11.8
 * @desc 使用配置类来代替xml配置文件
 */
@Configuration
@ComponentScan(basePackages ={"cn.zhanguozhi"} )
public class SpringConfig {

}
