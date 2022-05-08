package com.zjf.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjf.admin.bean.User;
import org.springframework.stereotype.Component;

/**
 * 继承baseMapper就有crud
 */
@Component
public interface UserMapper extends BaseMapper<User> {

}
