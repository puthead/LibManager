package com.ygz.service_base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lib.common.model.User;
import com.ygz.service_base.mapper.BookTypeMapper;
import com.ygz.service_base.pojo.BookType;
import com.ygz.service_base.service.BookTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
@Slf4j
public class BookTypeServiceImpl extends ServiceImpl<BookTypeMapper, BookType> implements BookTypeService {
    @Override
    public int insert(User obj) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(User obj) {
        return 0;
    }

    @Override
    public User queryObject(int id) {
        return null;
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
        return null;
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
    public List<User> queryObject(User obj) {
        return null;
    }

    @Override
    public Boolean getUserByUName(String uName, String uPassword) {
        return null;
    }
}
