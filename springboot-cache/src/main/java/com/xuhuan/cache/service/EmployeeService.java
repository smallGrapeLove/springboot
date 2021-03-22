package com.xuhuan.cache.service;

import com.xuhuan.cache.entity.Employee;
import com.xuhuan.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * @author huan.xu
 * @Time 2019-05-06 11:49
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp")
    public Employee getEmp(Integer id) {
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @Cacheable(cacheNames = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @Cacheable(cacheNames = "emp", key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("删除员工【" + id + "】");
    }

    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "emp", key = "#lastName")
            },
            put = {
                    @CachePut(cacheNames = "emp", key = "#result.id"),
                    @CachePut(cacheNames = "emp", key = "#result.emp")
            }
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpByLastName(lastName);
    }
}
