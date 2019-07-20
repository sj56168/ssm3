package main.cn.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by 我不管我最帅 on 2019/2/20.
 */
/*@RunWith(JUnit4.class)*/
public class ShiroTest {
    public static void main(String[] args) {
       ShiroTest s=new ShiroTest();
       s.test();
    }
  /*  @Test*/
    public void test() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //1) Subject：主体，可以看到主体可以是任何与应用交互的“用户”。
        Subject currUser = SecurityUtils.getSubject();

        Session session = currUser.getSession();
        session.setAttribute("somekey", "A");
        String value = (String) session.getAttribute("somekey");
        if (value.equals("A")) {
            System.out.println("somekey的值" + value);
        }


        //登录
        // //封装用户的数据
        UsernamePasswordToken token=new UsernamePasswordToken("zhang3","12345");
        token.setRememberMe(true);
        try {
            //  //将用户的数据token 最终传递到Realm中进行对比
            currUser.login(token);
        }catch (UnknownAccountException e){
            System.out.println("用户名不存在"+token.getPrincipal());
        }
        catch (IncorrectCredentialsException e){
            System.out.println("账户密码"+token.getPrincipal()+"不正确");
        }catch (LockedAccountException e){
            System.out.println("用户名"+token.getPrincipal()+"被锁定");
        }
        //验证成功后
        if(currUser.isAuthenticated()){
            System.out.println("用户"+token.getPrincipal()+"登录成功");
        }
        //测试角色
        System.out.println("是否拥有manager角色"+currUser.hasRole("manager"));
        //测试权限
        System.out.println("是否拥有user:create权限"+currUser.isPermitted("user:create"));
        //退出
        currUser.logout();


    }

}
