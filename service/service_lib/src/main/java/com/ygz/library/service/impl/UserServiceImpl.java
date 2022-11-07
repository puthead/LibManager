package com.ygz.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ygz.library.mapper.UserMapper;
import com.ygz.library.pojo.User;
import com.ygz.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


}
