package com.xuhuan.springboot.exception;

import com.xuhuan.springboot.pojo.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huan.xu
 * @Date 2020-11-22
 */
@ControllerAdvice
public class ExceptionHandler {

    public static final String ERROR_VIEW = "error";

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) throws Exception {

        e.printStackTrace();

        if (isAjax(reqest)) {
            return ResponseResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    /**
     * @Description: 判断是否是ajax请求
     */
    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals(httpRequest.getHeader("X-Requested-With").toString()));
    }
}
