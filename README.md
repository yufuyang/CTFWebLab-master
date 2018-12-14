# CTFWebLab
:school: 校内网络安全实验平台

## 项目基础架构

更改整体前后端分离验证架构，因改动较大，另开一个项目重新做版本控制，需重新clone项目，麻烦各位了

### shiro拦截登录，权限控制

配置相关拦截登录，权限控制接口，修改applicationContext.xml中：

```xml
 <property name="filterChainDefinitions">
            <value>
                /system/v1/logout =logout
                /system/v1/login=anon
                /system/v1/randomcode =anon
                /swagger-ui.html =anon
                /swagger-resources/** =anon
                /v2/** =anon
                /webjars/** =anon
                /** =authc
            </value>
 </property>
```

集成注释，可用@RequiresPermissions("course:query")做相关权限控制

## 集成swagger

在项目启动的情况下，访问 http://localhost:8080/swagger-ui.html ，修改resource下的swagger.properties 更改首页说明文档

## 数据库相关

初始化数据库文件为根目录下init.sql文件，本地创建ctfplantform数据库，在该数据库下运行init.sq

12/10： 数据库表中测试数据部分填充

## 实体类相关

上传了大致确定的实体类，如遇到与自己开发有关的实体类内容需要修改，请开另一条的分支进行开发，在做分支整合的时候，这边将会统一做更改实体类。



## 项目基本架构已经完整上传 

至此，项目完整的基本架构已经完全上传，另上传Course 课程部分接口作为参考，有运行不起来的情况请留言