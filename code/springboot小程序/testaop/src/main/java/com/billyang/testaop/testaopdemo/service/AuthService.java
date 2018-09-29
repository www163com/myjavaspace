package com.billyang.testaop.testaopdemo.service;

import com.billyang.testaop.testaopdemo.security.CurrentUserHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AuthService {
    public void checkAccess(){
        String user = CurrentUserHolder.get();
        System.out.println("进行权限校验");
        if(!"admin".equals(user)){
            throw new RuntimeException("operation not allow");
        }
    }
}
