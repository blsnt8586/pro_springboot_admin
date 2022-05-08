package com.zjf.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web Controller的异常
 */
@Slf4j
@ControllerAdvice
public class GlobeExceptionHandler {

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class}) //异常处理
    public String handleArithException(Exception e) {
        log.info("异常{}", e);
        return "login";//视图地址
    }
}
