package com.billyang.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author yangcan14944
 * @version V1.0
 * @Project myshiro
 * @Package com.billyang.test
 * @Description: ${todo}
 * @date 2018.12.26
 * @time 14:23
 */
public class JdbcRealmTest {
    DruidDataSource dataSource = new DruidDataSource();
    {
        dataSource.setUrl("jdbc:mysql://localhost:3306/myshiro");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
    }
    @Test
    public void testJdbcRealm(){
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        //设置查询权限数据
        //jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "select password from test_user where name=?";
        jdbcRealm.setAuthenticationQuery(sql);
       //1.创建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);
        //2.主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        //UsernamePasswordToken token = new UsernamePasswordToken("billyang","123456");
        UsernamePasswordToken token = new UsernamePasswordToken("xiaoming","111111");
        subject.login(token);

        System.out.println("isAuthenticated:"+subject.isAuthenticated());
        subject.checkRole("admin");
        subject.checkPermission("user:delete");
    }
}
