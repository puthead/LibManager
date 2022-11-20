package com.ygz.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lib.common.model.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
