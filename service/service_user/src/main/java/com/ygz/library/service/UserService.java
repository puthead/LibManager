package com.ygz.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lib.common.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService extends IService<User> {
    int insert(User obj);

    int delete(int id);

    int update(User obj);

    int updateUser(String username,String password,int id);

    User queryObject(int id);

    int queryCount();

    List<User> queryAll();

    List<User> queryPage(int offset, int size);

    int querySearchCount(String search);

    List<User> querySearchPage(String search, int offset, int size);

    List<User> queryObject(User obj);

    Integer getCountByUName(String uName);

    User getUserByUName(String uName);
}
