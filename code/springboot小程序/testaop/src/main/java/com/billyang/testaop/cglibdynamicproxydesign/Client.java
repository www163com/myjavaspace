package com.billyang.testaop.cglibdynamicproxydesign;

import com.billyang.testaop.staticproxydesign.RealSubject;
import com.billyang.testaop.staticproxydesign.Subject;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass =  true)
public class Client {
    public  static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.request();
    }
}
