package com.zjf.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.zjf.admin.mapper")
@ServletComponentScan(basePackages = "com.zjf.admin")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class ProSpringbootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProSpringbootAdminApplication.class, args);
    }

}
