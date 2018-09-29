package com.billyang.testaop.testaopdemo.service.sub;

import org.springframework.stereotype.Service;

@Service
public class SubExecutionService {
    public void log(){
        System.out.println("execute log method in sub service package");
    }
}
