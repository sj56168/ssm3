package main.cn.jason;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

/**
 * Created by 我不管我最帅 on 2019/2/21.
 */
public class DatabaseRealm extends AuthorizingRealm {
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
   /*    //能进入这里说明认证通过
        String username=(String)principalCollection.getPrimaryPrincipal();
        //通过DAO获取角色和权限
        Set<String> permisssions=new DAO().listPermissions(username);
        Set<String> roles=new DAO().listRoles(username);
        //授权对象
        SimpleAuthorizationInfo s=new SimpleAuthorizationInfo();
        s.setStringPermissions(permisssions);
        s.setRoles(roles);
        return s;*/
   return null;
    }
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*UsernamePasswordToken t= (UsernamePasswordToken) authenticationToken;
        //获取账号密码
        String username=t.getPrincipal().toString();
        String passwd=new String(t.getPassword());
        //获取数据库中的密码
        String passwdDB=new DAO().getPassword(username);
        //如果为空就是账号不存在，如果不相同就是密码错误，但是都抛出AuthenticationException，
        // 而不是抛出具体错误原因，免得给破解者提供帮助信息
            if(null==passwdDB||!passwd.equals(passwd)){
                throw new AuthenticationException();
            }
    //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
        SimpleAuthenticationInfo a=new SimpleAuthenticationInfo(username,passwd,getName());
        return a;*/
        return null;
    }
}
