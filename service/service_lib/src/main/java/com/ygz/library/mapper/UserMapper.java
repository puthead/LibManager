package com.ygz.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ygz.library.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
