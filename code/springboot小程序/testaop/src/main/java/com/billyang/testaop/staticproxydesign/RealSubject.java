package com.billyang.testaop.staticproxydesign;

public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("real subject execute");
    }
}
