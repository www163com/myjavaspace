package com.billyang.girl.utils;

import com.billyang.girl.domain.Result;

public class ResultUtils {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("处理成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
      return success(null);
    }
    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }
}
