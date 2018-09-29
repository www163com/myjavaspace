package com.billyang.testaop.chaindegisn;

import java.util.Arrays;
import java.util.List;

public class ChainClient {
    static class ChainHandlerA extends ChainHandler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by A");
        }
    }
    static class ChainHandlerB extends ChainHandler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by B");
        }
    }
    static class ChainHandlerC extends ChainHandler{
        @Override
        protected void handleProcess() {
            System.out.println("handle by C");
        }
    }
    public static void main(String[] args){
        List<ChainHandler> handlers = Arrays.asList(new ChainHandlerA(),new ChainHandlerB(),new ChainHandlerC());
        Chain chain = new Chain(handlers);
        chain.proceed();
    }
}
