package com.ygz.library.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ygz.library.mapper.ReaderMapper;
import com.ygz.library.pojo.Reader;
import com.ygz.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Repository
public class ReaderServiceImpl extends ServiceImpl<ReaderMapper,Reader> implements ReaderService {
    @Autowired
    private ReaderMapper mapper;


    @Override
    public int insert(Reader obj) {
        return 0;
    }

    @Override
    public int delete(int Id) {
        int i = mapper.deleteById(Id);
        return i;
    }

    @Override
    public int update(Reader obj) {
        return 0;
    }

    @Override
    public Reader queryObject(int Id) {
        try {
            return mapper.queryObject(Id);
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
    public List<Reader> queryAll() {
        return null;
    }

    @Override
    public List<Reader> queryPage(int offset, int size) {
        // 构造条件
        QueryWrapper<Reader> queryWrapper = new QueryWrapper<>();

        //
        Page<Reader> Reader_page = new Page<>(offset, size);

        Page<Reader> pageParam = mapper.selectPage(Reader_page, queryWrapper);

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
    public List<Reader> querySearchPage(String search, int offset, int size) {
        return null;
    }

    @Override
    public List<Reader> queryObject(Reader obj) {           //通过对象查找  暂时无法使用
        Map<String, Object> map = new HashMap<>();
        map.put("id",obj.getId());
        map.put("name",obj.getName());
        map.put("sex",obj.getSex());
        map.put("phone",obj.getPhone());
        map.put("department",obj.getDepartment());
        map.put("register_date",obj.getRegisterDate());
        map.put("lendable_time",obj.getLendableTime());
        System.out.println("-------------------------");
        System.out.println(map);
        return mapper.selectByMap(map);
    }
}
