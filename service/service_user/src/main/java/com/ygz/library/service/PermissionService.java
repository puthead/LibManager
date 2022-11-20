package com.ygz.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lib.common.model.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionService extends IService<Permission> {
    List<Permission> findFirstPermissionByRoleId(Integer roleId);
}
