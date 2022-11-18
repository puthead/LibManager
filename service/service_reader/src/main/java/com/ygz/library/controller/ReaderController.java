package com.ygz.library.controller;

import com.ygz.library.pojo.Reader;
import com.ygz.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping("queryAll")
    public List<Reader> queryAll(){
        List<Reader> list = readerService.list();
        return list;
    }

    @RequestMapping("list")
    public Map<String, Object> list(Integer page) {
        int size = 3;
        int currentPage = page;
        int offset = (page - 1) * size;
        int count = readerService.queryCount();
        int totalPage = (count + size - 1) / size;
        List<Reader> list = readerService.queryPage(offset, size);
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
