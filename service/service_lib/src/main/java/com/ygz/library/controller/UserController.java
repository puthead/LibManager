package com.ygz.library.controller;

import com.ygz.library.pojo.User;
import com.ygz.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryAll")
    public List<User> queryAll(){
        List<User> list = userService.list();
        return list;
    }
}
