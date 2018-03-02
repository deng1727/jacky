项目介绍：     
------  
Lin基于SpringBoot,目标是实现自动办公,现阶段整合springmvc + shiro + mybatis + Thymeleaf等常见框架，包含用户管理、部门管理、通知管理、日志管理、便签、角色管理、菜单配置 模块。   
           
默认管理员账号：ttt  密码：ttt
------
功能介绍：
------

1.用户管理 2.部门管理模块 3.通知管理 4.修改密码 5.登陆日志 6.操作日志 7.便签 8.角色管理       
        ★添加用户后，密码默认为111111    
        ★用户密码重置后，密码默认为111111         
        ★部门解散后，此部门用户自动设置部门为 未分配    
        ★删除角色后，之前此角色用户自动配置为 用户       
        ★可通过角色来配置要显示的菜单       

项目特点
------
1.项目基于SpringBoot，简化了大量的配置和Maven依赖。   
2.日志记录系统，记录用户的登陆、登出，用户执行的操作，通过@BizLog注解以及Spring中的AOP功能，记录了具体到用户的业务操作、登入登出，并且可以下载excel格式，方便查看。     
3.利用Thymeleaf使得前端html代码看起来更加清晰。     
4.通过角色管理来配置菜单，达到菜单为不同部门显示的目的，间接实现了权限的管理。

javabean方式的配置文件
------
Lin中摒弃了传统的xml配置文件，使得配置文件更加清晰、简洁，下列为Shrio配置文件中的片段
```
@Configuration
public class ShiroConfig {
    /**
     * 安全管理器
     * @param rememberMeManager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(CookieRememberMeManager rememberMeManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRememberMeManager(rememberMeManager);
        securityManager.setRealm(this.shiroDbRealm());
        return securityManager;
    }
 
    @Bean
    public ShiroDbRealm shiroDbRealm(){
        return new ShiroDbRealm();
    }

```
日志记录
------
日志记录通过aop(LogAop类)方式对所有包含@BizLog注解的方法进行aop切入，通过@Bizlog注解中的value属性来获取用户所做的操作，封装为日志类，异步存入数据库中（通过ScheduledThreadPoolExecutor类）。
```
    @Pointcut("@annotation(com.du.lin.annotation.BizLog)")
    public void logCut() {

    }
```
使用Thymeleaf使得html代码更简洁
------
下面是便签功能实现的部分片段。
后端：
```
     List<Memo> list = service.getUserMemoList();
     request.setAttribute("memolist", list);
```
前端html：
```
      <li th:each="memo,memoStat:${memolist}">
         <div>
           <small th:text="${memo.time}"></small>
              <small th:text="${memo.time}"></small>
                 <h4 th:text="${memo.title}"></h4>
                    <p th:text="${memo.text}"></p>
                      <a th:id="${memo.id}" onclick="deletememodialog(this)">   
                          <i class="fa fa-trash-o "></i></a>
                        </div>
                    </li>
```
所用框架
------
### 前端

 1. Bootstrap
 2. jQuery
 3. jqGrid
 4. jstree
 5. SweetAlert
    

### 后端

 1. SpringBoot
 2. MyBatis
 3. Spring
 4. Thymeleaf
 5. Ehcache
 6. Kaptcha
 7. Shiro

项目截图
------
登陆界面
![登陆界面](https://gitee.com/uploads/images/2017/1031/101142_8fdc30b7_1308187.jpeg "1.jpg")
用户管理界面
![用户管理界面](https://gitee.com/uploads/images/2017/1031/101333_c48251c1_1308187.jpeg "2.jpg")
通知管理
![通知管理](https://gitee.com/uploads/images/2017/1031/101341_ce863afe_1308187.jpeg "3.jpg")
登陆日志界面
![登陆日志界面](https://gitee.com/uploads/images/2017/1031/101349_a52daf1e_1308187.jpeg "4.jpg")
修改密码
![修改密码](https://gitee.com/uploads/images/2017/1031/101358_06fd4a4d_1308187.jpeg "5.jpg")
便签界面
![便签](https://gitee.com/uploads/images/2017/1114/171803_a17f3992_1308187.png "便签.png")
角色管理
![角色管理](https://gitee.com/uploads/images/2017/1114/171836_8c089964_1308187.png "JUSE.png")}