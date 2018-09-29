package com.billyang.testaop.testaopdemo.security;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PkgPointcutAspect {
    @Pointcut("within((com.billyang.testaop.testaopdemo.service.ProductService2))")
    public void log(){
        System.out.println("######");
    }
    @Before("log()")
    public void before(){
        System.out.println();
        System.out.println("$$$$");
    }
}
