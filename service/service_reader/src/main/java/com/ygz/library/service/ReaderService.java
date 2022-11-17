package com.ygz.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ygz.library.pojo.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReaderService extends IService<Reader> {

    int insert(Reader obj);

    int delete(int id);

    int update(Reader obj);

    Reader queryObject(int id);

    int queryCount();

    List<Reader> queryAll();

    List<Reader> queryPage(int offset, int size);

    int querySearchCount(String search);

    List<Reader> querySearchPage(String search, int offset, int size);

    List<Reader> queryObject(Reader obj);

}
