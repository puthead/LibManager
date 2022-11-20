package com.ygz.service_base.service;

import com.lib.common.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookTypeService {
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
