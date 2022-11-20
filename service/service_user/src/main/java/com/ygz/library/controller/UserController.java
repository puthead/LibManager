package com.ygz.library.controller;

import com.lib.common.model.Permission;
import com.lib.common.model.User;
import com.lib.common.res.Meta;
import com.lib.common.res.ResponseEntity;
import com.lib.common.res.ResultJson;
import com.lib.common.utils.RedisUtil;
import com.ygz.library.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private UserService userService;

    //全查
    @GetMapping("queryAll")
    public ResponseEntity queryAll(@RequestHeader Map<String, String> headers){
        String str= redisUtil.isExistKey(headers.get("token"));
        log.debug("status",str);
        if (str == null){
            return ResponseEntity.success(600);
        }

        List<User> list = userService.list();
        return ResponseEntity.success(200,list);
    }

   @PostMapping("login")
   public ResultJson login(@RequestBody User user){
        log.debug("user:",user);
        String key="pc-"+ UUID.randomUUID().toString().replace("-","");
        Boolean flag=userService.getUserByUName(user.getUsername(),user.getPassword());
        user.setPassword(null).setToken(key);
        if (flag) {
            redisUtil.AddRedis(key, user);
            System.out.println(user);

            return new ResultJson().setMeta(new Meta().setStatus(Meta.OK).setMsg("登录成功")).setData(user);
        }
        return new ResultJson().setMeta(new Meta().setStatus(Meta.INTERNAL_SERVER_ERROR).setMsg("登录失败"));
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

    @GetMapping("/menus")
    public ResultJson Menu(){
        Permission permission1 = new Permission()
                .setId(104)
                .setAuthName("list")
                .setPath("user");
        List<Permission> list1 =new ArrayList<>();
        list1.add(permission1);
        Permission permission =new Permission()
                .setId(101)
                .setAuthName("Manager")
                .setChildren(list1)
                .setPath("user");
        List<Permission> list =new ArrayList<>();
        list.add(permission);
        list.add(permission);
        return new ResultJson().setMeta(new Meta().setStatus(200).setMsg("获取菜单列表成功")).setData(list);
    }
}
