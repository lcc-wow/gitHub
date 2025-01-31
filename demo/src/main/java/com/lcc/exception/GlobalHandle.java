package com.lcc.exception;


import com.lcc.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandle {
    @ExceptionHandler(Exception.class)
    public Result handle(Exception e) {
        e.printStackTrace();
        return Result.error("对不起，操作失败，请联系管理员");
    }
}
