package com.billyang.testaop.staticproxydesign;

public class ProxySubject implements  Subject {
    private RealSubject realSubject;

    public ProxySubject(RealSubject subject) {
        this.realSubject = subject;
    }

    @Override
    public void request() {
        System.out.println("before");
        try {
            realSubject.request();
        }catch (Exception e){
            System.out.println("ex:"+e.getMessage());
            throw e;
        }finally {
            System.out.println("after");
        }

    }
}
