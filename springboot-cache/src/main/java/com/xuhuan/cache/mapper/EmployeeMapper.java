package com.xuhuan.cache.mapper;

import com.xuhuan.cache.entity.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author huan.xu
 * @Time 2019-05-06 11:11
 */
@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id=#{id}")
    Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{denger},d_id=#{dId} where id=#{id}")
    void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    void delEmp(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id}) values(#{lastName},#{email},#{gender},#{dId})")
    void insertEmp(Employee employee);

    @Select("select * from employee where lastName=#{lastName}")
    Employee getEmpByLastName(String lastName);
}
