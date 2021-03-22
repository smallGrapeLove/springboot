package com.xuhuan.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * 搭建基本环境
 * 1.导入数据库文件创建出department、employee表
 * 2.创建JavaBean封装对象
 * 3.整合mybatis
 * 		1）配置数据源信息
 * 		2）使用注解版的mybatis
 * 			1.@MapperScan指定需要扫描的mapper接口所在的包
 * 		3）
 *开始使用注解
 * 1.使用@EnableCaching
 * 2.标注缓存注解
 */
@MapperScan("com.xuhuan.cache.mapper")
@SpringBootApplication
@EnableCaching
public class Springboot1CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot1CacheApplication.class, args);
	}

}
