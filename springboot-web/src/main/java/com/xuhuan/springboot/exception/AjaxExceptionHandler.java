package com.xuhuan.springboot.exception;

import com.xuhuan.springboot.pojo.ResponseResult;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huan.xu
 * @Date 2020-11-22
 */
//@RestControllerAdvice
public class AjaxExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseResult errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        return ResponseResult.errorException(e.getMessage());
    }
}
