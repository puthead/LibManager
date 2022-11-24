package com.ygz.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lib.common.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where u_id = #{uId}")
    public User queryObject(int id) throws SQLException;

    @Update("update user set username = #{username},password = #{password} where u_id = #{uId}")
    public int updateUser(String username, String password,int uId) throws SQLException;
}
