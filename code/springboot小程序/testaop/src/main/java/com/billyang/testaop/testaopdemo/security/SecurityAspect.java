package com.billyang.testaop.testaopdemo.security;

import com.billyang.testaop.testaopdemo.service.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
    @Autowired
    AuthService authService;
    //有AdminOnly注解的进行权限校验
    @Pointcut("@annotation(AdminOnly)")
    public void adminOnly(){

    }
    @Before("adminOnly()")
    public void check(){
        authService.checkAccess();
    }
}
