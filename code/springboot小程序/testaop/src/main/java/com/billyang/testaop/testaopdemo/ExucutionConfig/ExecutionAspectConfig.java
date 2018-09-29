package com.billyang.testaop.testaopdemo.ExucutionConfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionAspectConfig {
    @Pointcut("execution(String com.billyang.testaop.testaopdemo.service..*Service.*(..))")
        public void matchCondition(){

        }
        @Before(value = "matchCondition() && args()")
        public void before(){
            System.out.println();
            System.out.println("########before");
    }
}
