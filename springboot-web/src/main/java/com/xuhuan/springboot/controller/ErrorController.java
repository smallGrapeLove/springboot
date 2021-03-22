package com.xuhuan.springboot.controller;

import com.xuhuan.springboot.pojo.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huan.xu
 * @Date 2020-11-22
 */
@Controller
@RequestMapping("/err")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {
        int a = 1 / 0;
        return "";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxError() {

        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public ResponseResult getAjaxError() {
        int a = 1 / 0;
        return ResponseResult.ok();
    }
}
