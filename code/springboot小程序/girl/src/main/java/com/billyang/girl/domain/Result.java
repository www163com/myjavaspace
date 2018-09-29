package com.billyang.girl.domain;

//http请求返回最外层对象
public class Result<T> {
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //具体类容
    private T Data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
