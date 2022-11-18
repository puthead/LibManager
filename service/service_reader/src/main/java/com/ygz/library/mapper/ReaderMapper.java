package com.ygz.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ygz.library.pojo.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

@Mapper
public interface ReaderMapper extends BaseMapper<Reader> {

    @Select("select * from user where id = #{Id}")
    Reader queryObject(int id)throws SQLException;
}
