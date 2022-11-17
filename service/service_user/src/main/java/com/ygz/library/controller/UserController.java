package com.ygz.library.controller;

import com.ygz.library.pojo.User;
import com.ygz.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserService userService;

    //全查
    @GetMapping("queryAll")
    public List<User> queryAll(){
        List<User> list = userService.list();
        return list;
    }


    @GetMapping("test")
    public String test(){
        return "list";
    }

    @RequestMapping("delete")
    public int delById(int uId){
        int k = userService.delete(uId);
        System.out.println("k :  "+k);
        return k;
    }

    @RequestMapping("queryObject")
    public User queryObject(int uId){
        User u = userService.queryObject(uId);
        System.out.println(u);
        return u;
    }


    // 分页查询
    @RequestMapping("list")
    public Map<String, Object> list(Integer page) {
        int size = 3;
        int currentPage = page;
        int offset = (page - 1) * size;
        int count = userService.queryCount();
        int totalPage = (count + size - 1) / size;
        List<User> list = userService.queryPage(offset, size);
        // System.out.println(list);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", count);
        map.put("currentPage", currentPage);
        map.put("totalPage", totalPage);
        // System.out.println(map);
        return map;

    }
}
