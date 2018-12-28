package com.billyang.shiro.realm;

import com.billyang.dao.UserDao;
import com.billyang.vo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author yangcan14944
 * @version V1.0
 * @Project myshiro
 * @Package com.billyang.shirotest.realm
 * @Description: ${todo}
 * @date 2018.12.26
 * @time 14:54
 */
public class CustomRealm extends AuthorizingRealm{
    @Resource
    private UserDao userDao;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("从数据库中获取授权数据");
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //从数据库或者缓存中获取角色数据
        Set<String> roles = getRolesByUserName(userName);
        //获取权限数据
        Set<String> permissions = getPermissionsByUserName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    private Set<String> getPermissionsByUserName(String userName) {
        Set<String> sets = new HashSet<String>();
        sets.add("user:delete");
        //sets.add("user:update");
        return sets;
    }


    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.从主体传过来的认证信息中获取用户名
        String userNamme = (String) authenticationToken.getPrincipal();
        //2.通过用户名从数据库中获取密码
        String password = getPasswordByUserName(userNamme);
        if(null==password){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userNamme,password,"customRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("billyang"));
        return authenticationInfo;
    }
    //从数据库查询角色信息
    private Set<String> getRolesByUserName(String userName) {
        List<String> list = userDao.queryRolesByUserName(userName);
        Set<String> sets = new HashSet<String>(list);
        return sets;
    }

    //从数据库查询用户密码
    private String getPasswordByUserName(String userNamme) {
        User user = userDao.getUserByUserName(userNamme);
        if(user!=null){
            return user.getPassword();
        }
        return null;
    }
    public static void main(String[] args){
        //Md5Hash md5Hash = new Md5Hash("123456","billyang");
        Md5Hash md5Hash = new Md5Hash("123456","billyang");
        System.out.println(md5Hash.toString());
    }
}
