package com.xuhuan.cache.entity;

/**
 * @author huan.xu
 * @Time 2019-05-06 11:02
 */
public class Department {

    private Integer id;
    private Integer departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(Integer departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName=" + departmentName +
                '}';
    }
}
