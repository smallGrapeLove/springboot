package com.xuhuan.springboot.controller;

import com.xuhuan.springboot.pojo.Resource;
import com.xuhuan.springboot.pojo.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huan.xu
 * @Date 2020-11-22
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private Resource resource;

    @RequestMapping("/show")
    public Object show() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return ResponseResult.ok(bean);
    }
}
