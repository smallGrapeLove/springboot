package com.xuhuan.cache.controller;

import com.xuhuan.cache.entity.Employee;
import com.xuhuan.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huan.xu
 * @Time 2019-05-06 11:50
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeService.getEmp(id);
    }

    @GetMapping("/emp")
    public Employee update(Employee employee) {
        employeeService.updateEmp(employee);
        return employee;
    }

    @GetMapping("/emp/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/last/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
        return employeeService.getEmpByLastName(lastName);
    }
}
