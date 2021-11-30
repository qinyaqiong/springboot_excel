package com.sjh.config;

import com.sjh.utils.Result;
import com.sjh.utils.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
    @ExceptionHandler(Exception.class)
    public Result onError(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return new Result(500,e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result runtime(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        if(e.getMessage().contains("cannot be null")
                || e.getMessage().contains("doesn't have a default value")){
            return new Result(500,"表单数据不完整");
        }
        return new Result(ResultCode.ERROR);
    }
}
