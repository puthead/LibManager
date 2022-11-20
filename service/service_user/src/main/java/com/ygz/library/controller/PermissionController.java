package com.ygz.library.controller;

import com.lib.common.res.Meta;
import com.lib.common.res.ResultJson;
import com.lib.common.utils.TreeUtil;
import com.ygz.library.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    @GetMapping("/menus")
    public ResultJson Menu(){
       List list=permissionService.findFirstPermissionByRoleId(1);
       list= TreeUtil.toTree(list);
        return new ResultJson().setMeta(new Meta().setStatus(200).setMsg("获取菜单列表成功")).setData(list);
    }
}
