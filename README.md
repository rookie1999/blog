# blog
#@date 2019.11.5
#v1.0

目前为止 只做了登录和注册(只是业务逻辑写好了 测试了一遍)

对项目的初步设定是：做一个blog  可以发帖 评论 写日记(这个版块只能用户自己看到)
前端页面还需要优化  对输入参数还需要进行检查
StatusCode 枚举类还没有用到  只是有这个想法  在内部业务逻辑之中 通过错误码传递 最后返回给页面的是错误码指代的错误信息
SpringContext类还可以优化  这是后面要学习的一个地方  目前只是用这个获取静态单例的ApplicationContext 得到IOC容器

现在使用的还是简单的servlet和jdbc
想之后使用spring boot、mybatis、spring mvc技术  

#@date 2019.11.6
#v1.1

change:
1.增加了cookie机制，完成同一次会话内一次登录之后免密操作
2.增加了注销功能  可以重新登录或注册
3.user表增加了last_login_time字段 对UserInfo对象也修改 增加了String lastLoginTime属性

#@date 2019.11.8
#v1.2

change:
1.增加了欢迎页的页面计数功能，该计数是所有用户的历史总计数之和
2.移除了原来的xml配置功能，采用了基于配置类的Spring配置 
  AnnotationConfigApplicationContext
 3.对于原来使用Cookie的用户信息记录  转用Session机制
 
注意：
 历史总访问计数记录在/config/count.txt，但是项目自动生成一个同名文件在target中，并且程序访问的是target的文件
 
expectation:
对于cookie机制 目前只是检测uname是否存在作为依据
  想使用username+last_login_time
  通过md5加密算法存储两个相同的cookie
  每次需要登录前 先核对这两个

#@date 2019.11.25
#v1.3
change：
1.原来的configServlet被移除了，使用过滤器CounFilter替代，该过滤器对welcomePage.jsp的请求进行过滤，每次请求，即相当于访问一次该页面 
2.增加了统计在线人数的功能，使用监听器，一旦有新的session创建即在线人数增加一个 
3.增加了全局过滤器，专门设置响应和请求的编码格式 
4.对于jsp中的数据使用EL表达式和jstl进行获取 
5.welcomPage.jsp使用了模板 
6.从之前的验证cookie变成了验证session
 

  
