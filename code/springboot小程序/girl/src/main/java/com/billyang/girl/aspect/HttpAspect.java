package com.billyang.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
     private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

//    @Before("execution(public * com.billyang.girl.controller.GirlController.*(..))")
//    public void log(){
//        System.out.println("11111");
//    }
//    @After("execution(public * com.billyang.girl.controller.GirlController.*(..))")
//    public void log2(){
//        System.out.println("22222");
//    }
    @Pointcut("execution(public * com.billyang.girl.controller.GirlController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
//        System.out.println("111111");
//        logger.info("1111111");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("IP={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
//        System.out.println("22222");
        logger.info("222222222");
    }
    @AfterReturning(returning = "obj",pointcut = "log()")
    public void doAfterReturning(Object obj){
        logger.info("response={}",obj.toString());
    }
}
