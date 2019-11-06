# blog
目前为止 只做了登录和注册(只是业务逻辑写好了 测试了一遍)

对项目的初步设定是：做一个blog  可以发帖 评论 写日记(这个版块只能用户自己看到)
前端页面还需要优化  对输入参数还需要进行检查
StatusCode 枚举类还没有用到  只是有这个想法  在内部业务逻辑之中 通过错误码传递 最后返回给页面的是错误码指代的错误信息
SpringContext类还可以优化  这是后面要学习的一个地方  目前只是用这个获取静态单例的ApplicationContext 得到IOC容器

现在使用的还是简单的servlet和jdbc
想之后使用spring boot、mybatis、spring mvc技术  
