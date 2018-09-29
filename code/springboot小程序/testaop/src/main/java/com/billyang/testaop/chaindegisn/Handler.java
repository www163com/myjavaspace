package com.billyang.testaop.chaindegisn;

public abstract class Handler {
    private Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void execute(){
        handleProcess();
        if(successor != null ){
            successor.execute();
        }
    }
    protected abstract void handleProcess();
}
