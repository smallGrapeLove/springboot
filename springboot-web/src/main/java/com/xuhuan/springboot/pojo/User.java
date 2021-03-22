package com.xuhuan.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * @author huan.xu
 * @Date 2020-11-21
 */
public class User {
    private String name;
    private Integer age;

    /**
     * 忽略
     */
    @JsonIgnore
    private String password;

    /**
     * pattern 格式
     * locale 地区，zh：中国
     * timezone 时区，GMT+8：东八区
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date birthday;

    /**
     * 为空就不展示
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
