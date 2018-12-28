package com.billyang.test;

import com.billyang.shirotest.realm.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author yangcan14944
 * @version V1.0
 * @Project myshiro
 * @Package com.billyang.test
 * @Description: ${todo}
 * @date 2018.12.26
 * @time 15:03
 */
public class CustomRealmTest {
    @Test
    public void testCustomRealm(){

        CustomRealm customRealm = new CustomRealm();

        //1.创建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        customRealm.setCredentialsMatcher(matcher);
        //2.主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        //UsernamePasswordToken token = new UsernamePasswordToken("billyang","123456");
        UsernamePasswordToken token = new UsernamePasswordToken("billyang","123456");
        subject.login(token);

        System.out.println("isAuthenticated:"+subject.isAuthenticated());
        subject.checkRole("user");
        subject.checkPermission("user:update");
    }
}
