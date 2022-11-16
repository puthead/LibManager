package com.ygz.library.controller;

import com.ygz.library.pojo.Book;
import com.ygz.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/book")
public class BookController {



    @Autowired
    private BookService bookService;

    //全查
    @GetMapping("queryAll")
    public List<Book> queryAll(){
        List<Book> list = bookService.list();
        return list;
    }

    @GetMapping("test")
    public String test(){
        return "list";
    }

    @RequestMapping("delete")
    public int delById(int uId){
        int k = bookService.delete(uId);
        System.out.println("k :  "+k);
        return k;
    }

    @RequestMapping("queryObject")
    public Book queryObject(int uId){
        Book u = bookService.queryObject(uId);
        System.out.println(u);
        return u;
    }


    // 分页查询
    @RequestMapping("list")
    public Map<String, Object> list(Integer page) {
        int size = 3;
        int currentPage = page;
        int offset = (page - 1) * size;
        int count = bookService.queryCount();
        int totalPage = (count + size - 1) / size;
        List<Book> list = bookService.queryPage(offset, size);
        // System.out.println(list);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", count);
        map.put("currentPage", currentPage);
        map.put("totalPage", totalPage);
        // System.out.println(map);
        return map;

    }
}
