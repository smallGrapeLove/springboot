package com.xuhuan.cache;

import com.xuhuan.cache.entity.Employee;
import com.xuhuan.cache.mapper.DepartmentMapper;
import com.xuhuan.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot1CacheApplicationTests {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        Employee emp = employeeMapper.getEmpById(1);
        System.out.println(emp);
    }

    /**
     * redis常见的五大数据类型
     * string
     * list
     * set
     * hash
     * zSet
     */
    @Test
    public void testRedis(){
        //redis保存string
        stringRedisTemplate.opsForValue().append("msg","hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);

        stringRedisTemplate.opsForList().leftPush("myList","1");
        stringRedisTemplate.opsForList().leftPush("myList","2");
        stringRedisTemplate.opsForList().leftPush("myList","3");
        stringRedisTemplate.opsForList().leftPush("myList","4");

    }

    @Test
    public void testRedisObj(){
        Employee emp01 = employeeMapper.getEmpById(1);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        redisTemplate.opsForValue().set("emp-01",emp01);

    }

}
