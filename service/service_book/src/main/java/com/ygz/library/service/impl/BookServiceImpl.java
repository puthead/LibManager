package com.ygz.library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ygz.library.mapper.BookMapper;
import com.ygz.library.pojo.Book;
import com.ygz.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Repository
public class BookServiceImpl extends ServiceImpl<BookMapper,Book> implements BookService {
    @Autowired
    private BookMapper mapper;


    @Override
    public int insert(Book obj) {
        return 0;
    }

    @Override
    public int delete(int uId) {
        int i = mapper.deleteById(uId);
        return i;
    }

    @Override
    public int update(Book obj) {
        return 0;
    }

    @Override
    public Book queryObject(int uId) {
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
    public List<Book> queryAll() {
        return null;
    }

    @Override
    public List<Book> queryPage(int offset, int size) {
        // 构造条件
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();

        //
        Page<Book> Book_page = new Page<>(offset, size);

        Page<Book> pageParam = mapper.selectPage(Book_page, queryWrapper);

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
    public List<Book> querySearchPage(String search, int offset, int size) {
        return null;
    }

    @Override
    public List<Book> queryObject(Book obj) {           //通过对象查找  暂时无法使用
        Map<String, Object> map = new HashMap<>();
        map.put("b_id", obj.getBId());
        map.put("b_name", obj.getBName());
        map.put("ISBN", obj.getISBN());
        map.put("b_quantity",obj.getBQuantity());
        map.put("b_status",obj.getBStatus());
        System.out.println("-------------------------");
        System.out.println(map);
        return mapper.selectByMap(map);
    }
}
