package com.ygz.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ygz.library.pojo.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService extends IService<Book> {
    int insert(Book obj);

    int delete(int id);

    int update(Book obj);

    Book queryObject(int id);

    int queryCount();

    List<Book> queryAll();

    List<Book> queryPage(int offset, int size);

    int querySearchCount(String search);

    List<Book> querySearchPage(String search, int offset, int size);

    List<Book> queryObject(Book obj);
}
