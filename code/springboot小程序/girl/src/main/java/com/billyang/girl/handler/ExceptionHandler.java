package com.billyang.girl.handler;

import com.billyang.girl.domain.Result;
import com.billyang.girl.exception.GirlException;
import com.billyang.girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {
    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandler.class);
    @org.springframework.web.bind.annotation.ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtils.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.error("[系统异常]{}",e);
            return ResultUtils.error(-1,"未知错误");
        }

    }
}
