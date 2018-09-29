package com.billyang.testaop.testaopdemo.security;

public class CurrentUserHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<>();
    public static String get(){
        return holder.get()==null?"unknown":holder.get();
    }
    public static void set(String name){
        holder.set(name);
    }
}

