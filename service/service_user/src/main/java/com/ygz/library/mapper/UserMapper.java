package com.ygz.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lib.common.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where u_id = #{uId}")
    public User queryObject(int id) throws SQLException;

    @Update("update user set username = #{username},password = #{password} where u_id = #{uId}")
    public int updateUser(String username, String password,int uId) throws SQLException;

    @Select("Select * from user order by u_id limit #{offset},#{size}")
    public List<User> queryPage(Map<String, Integer> map) throws SQLException;

    @Select("select count(*) as num from user")
    public int queryCount() throws SQLException;
}
