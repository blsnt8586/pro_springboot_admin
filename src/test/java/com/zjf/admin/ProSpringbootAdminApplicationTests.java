package com.zjf.admin;

import com.zjf.admin.bean.User;
import com.zjf.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class ProSpringbootAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;


    @Transactional
    @Test
    void contextLoads() {
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from mybatis_plus");
//        maps.forEach(System.out::println);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        log.info("记录总数：{}",aLong);
        log.info("数据源类型：{}",dataSource.getClass());
    }

    @Test
    void testUser(){
        User user = userMapper.selectById(1);
        log.info(user.toString());
    }

    @Test
    void testRedis(){

    }


}
