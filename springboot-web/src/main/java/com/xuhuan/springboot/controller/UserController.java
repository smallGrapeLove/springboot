package com.xuhuan.springboot.controller;

import com.xuhuan.springboot.pojo.ResponseResult;
import com.xuhuan.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author huan.xu
 * @Date 2020-11-21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/show")
    public User show() {
        User user = new User();
        user.setName("zhangShan");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("123456");
        return user;
    }

    @RequestMapping("/show-detail")
    public ResponseResult showDetail() {
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setPassword("123456");
        return ResponseResult.ok(user);
    }
}
