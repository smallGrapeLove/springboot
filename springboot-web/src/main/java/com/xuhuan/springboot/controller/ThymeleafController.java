package com.xuhuan.springboot.controller;

import com.xuhuan.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huan.xu
 * @Date 2020-11-22
 */
@Controller
@RequestMapping("/tf")
public class ThymeleafController {

    @RequestMapping("/index")
    public String indexPage(ModelMap modelMap) {
        modelMap.addAttribute("name", "thymeleaf-zhangshan");
        return "thymeleaf/index";
    }

    @RequestMapping("/center")
    public String centerPage() {
        return "thymeleaf/center/center";
    }

    @RequestMapping("/test")
    public String testPage(ModelMap modelMap) {
        User user = new User();
        user.setName("other");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setDesc("<font color='green'><b>hello</b></font>");
        modelMap.addAttribute("user", user);

        List<User> userList=new ArrayList<>();
        User u1 = new User();
        u1.setName("张三");
        u1.setAge(18);
        u1.setBirthday(new Date());
        u1.setDesc("<font color='green'><b>hello</b></font>");
        userList.add(u1);

        User u2 = new User();
        u2.setName("李四");
        u2.setAge(19);
        u2.setBirthday(new Date());
        u2.setDesc("<font color='green'><b>hello</b></font>");
        userList.add(u2);

        User u3 = new User();
        u3.setName("王五");
        u3.setAge(17);
        u3.setBirthday(new Date());
        u3.setDesc("<font color='green'><b>hello</b></font>");
        userList.add(u3);

        modelMap.addAttribute("userList",userList);

        return "thymeleaf/test";
    }

    @PostMapping("/postform")
    public String postForm(User user) {
        System.out.println(user.getName());
        return "redirect:/tf/test";
    }
}
