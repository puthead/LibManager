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
        return 0;
    }

    @Override
    public int delete(int uId) {
        int i = mapper.deleteById(uId);
        return i;
    }

    @Override
    public int update(User obj) {
        return 0;
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
        return 0;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public List<User> queryPage(int offset, int size) {
        // 构造条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //
        Page<User> User_page = new Page<>(offset, size);

        Page<User> pageParam = mapper.selectPage(User_page, queryWrapper);

        // pageParam.getCurrent(); 查询当前页
        // pageParam.getPages(); 查询总页数
        // pageParam.getTotal();查询记录数

        return pageParam.getRecords();
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
    public List<User> queryObject(User obj) {           //通过对象查找  暂时无法使用
        Map<String, Object> map = new HashMap<>();
        map.put("u_id", obj.getUId());
        map.put("u_name", obj.getUsername());
        map.put("u_password", obj.getPassword());
        System.out.println("-------------------------");
        System.out.println(map);
        return mapper.selectByMap(map);
    }

    @Override
    public Boolean getUserByUName(String uName,String uPassword) {
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("username",uName);
        queryWrapper.eq("password",uPassword);
        Long count=mapper.selectCount(queryWrapper);
        System.out.println(count);
        if (count == 1L){
            return true;
        }
        return false;
    }
}
