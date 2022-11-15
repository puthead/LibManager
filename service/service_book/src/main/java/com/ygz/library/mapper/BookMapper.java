package com.ygz.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ygz.library.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    @Select("select * from user where u_id = #{uId}")
    public Book queryObject(int id) throws SQLException;

}
