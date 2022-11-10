package com.ygz.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ygz.library.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where u_id = #{uId}")
    public User queryObject(int id) throws SQLException;

}
