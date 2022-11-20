package com.ygz.library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lib.common.model.Permission;
import com.lib.common.model.RolePermission;
import com.ygz.library.mapper.PermissionMapper;
import com.ygz.library.mapper.RolePermissionMapper;
import com.ygz.library.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Autowired
    RolePermissionMapper rolePermissionMapper;
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> findFirstPermissionByRoleId(Integer roleId) {
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("role_id",roleId);
        List<RolePermission> rolePermissions=rolePermissionMapper.selectList(queryWrapper);
        Collection<Integer> search=new ArrayList<>() ;
        rolePermissions.forEach(rolePermission ->search.add(rolePermission.getPermissionId()) );

        QueryWrapper qw=new QueryWrapper();
        qw.in("id",search);
        qw.eq("type",1);
        qw.orderByAsc("order_rank");
        List<Permission> permissions=permissionMapper.selectList(qw);
        return permissions;
    }
}
