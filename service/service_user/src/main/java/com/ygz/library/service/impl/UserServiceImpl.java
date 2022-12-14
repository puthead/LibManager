package com.ygz.library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lib.common.model.User;
import com.ygz.library.mapper.UserMapper;
import com.ygz.library.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Repository
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper mapper;


    @Override
    public int insert(User obj) {
        int i = mapper.insert(obj);
        return i;
    }

    @Override
    public int delete(int uId) {
        int i = mapper.deleteById(uId);
        return i;
    }

    @Override
    public int update(User obj) {
        int i =mapper.update(obj,null);
        return i;
    }

    @Override
    public int updateUser(String username, String password,int uId) {
        try {
            return mapper.updateUser(username,password,uId);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    public User queryObject(int uId) {
        try {
            return mapper.queryObject(uId);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int queryCount() {
        try {
            return mapper.queryCount();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public List<User> queryPage(int offset, int size) {
        try {
            Map<String, Integer> map = new HashMap<>();
            map.put("offset", offset);
            map.put("size", size);
            return mapper.queryPage(map);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int querySearchCount(String search) {
        return 0;
    }

    @Override
    public List<User> querySearchPage(String search, int offset, int size) {
        return null;
    }

    @Override
    public List<User> queryObject(User obj) {           //??????????????????  ??????????????????
        Map<String, Object> map = new HashMap<>();
        map.put("u_id", obj.getUId());
        map.put("u_name", obj.getUsername());
        map.put("u_password", obj.getPassword());
        System.out.println("-------------------------");
        System.out.println(map);
        return mapper.selectByMap(map);
    }

    @Override
    public Integer getCountByUName(String uName) {
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("username",uName);
        Long count=mapper.selectCount(queryWrapper);
        System.out.println(count);
        return Math.toIntExact(count);
    }

    @Override
    public User getUserByUName(String uName) {
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("username",uName);
        User user=mapper.selectOne(queryWrapper);
        return user;
    }
}
