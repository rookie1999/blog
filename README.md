# blog
#@date 2019.11.5

目前为止 只做了登录和注册(只是业务逻辑写好了 测试了一遍)

对项目的初步设定是：做一个blog  可以发帖 评论 写日记(这个版块只能用户自己看到)
前端页面还需要优化  对输入参数还需要进行检查
StatusCode 枚举类还没有用到  只是有这个想法  在内部业务逻辑之中 通过错误码传递 最后返回给页面的是错误码指代的错误信息
SpringContext类还可以优化  这是后面要学习的一个地方  目前只是用这个获取静态单例的ApplicationContext 得到IOC容器

现在使用的还是简单的servlet和jdbc
想之后使用spring boot、mybatis、spring mvc技术  

#@date 2019.11.6

change:
1.增加了cookie机制，完成同一次会话内一次登录之后免密操作
2.增加了注销功能  可以重新登录或注册
3.user表增加了last_login_time字段 对UserInfo对象也修改 增加了String lastLoginTime属性

expectation:
对于cookie机制 目前只是检测uname是否存在作为依据
  想使用username+last_login_time
  通过md5加密算法存储两个相同的cookie
  每次需要登录前 先核对这两个
  
  
