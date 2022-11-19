package com.ygz.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lib.common.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User> {
    int insert(User obj);

    int delete(int id);

    int update(User obj);

    User queryObject(int id);

    int queryCount();

    List<User> queryAll();

    List<User> queryPage(int offset, int size);

    int querySearchCount(String search);

    List<User> querySearchPage(String search, int offset, int size);

    List<User> queryObject(User obj);

    Boolean getUserByUName(String uName,String uPassword);
}
