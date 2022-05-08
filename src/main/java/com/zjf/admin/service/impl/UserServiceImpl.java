package com.zjf.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjf.admin.bean.User;
import com.zjf.admin.mapper.UserMapper;
import com.zjf.admin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
