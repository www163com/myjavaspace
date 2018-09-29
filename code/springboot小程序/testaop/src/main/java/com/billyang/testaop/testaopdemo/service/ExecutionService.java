package com.billyang.testaop.testaopdemo.service;

import org.springframework.stereotype.Service;

@Service
public class ExecutionService {
    public void log1(){
        System.out.println("execute log1 method in service package");
    }
    public String log2(){
        System.out.println("execute log2 method in service package");
        return "!!";
    }
    public void log3(){
        System.out.println("execute log3 method in service package");
    }
}
