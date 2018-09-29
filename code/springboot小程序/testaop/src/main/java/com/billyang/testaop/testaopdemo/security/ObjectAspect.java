package com.billyang.testaop.testaopdemo.security;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ObjectAspect {
    @Pointcut("this(com.billyang.testaop.testaopdemo.service.ProductService3)")
    public void log(){}

    @Before("log()")
    public void beforeLog(){
        System.out.println("object point cut");
    }
    @Pointcut("bean(productService3)")
    public void log2(){}

    @Before("log()")
    public void beforeLog2(){
        System.out.println("object point cut log112");
    }
}
