package com.lib.common.utils;

import com.lib.common.model.Permission;

import java.util.ArrayList;
import java.util.List;

public class TreeUtil {
    /**
     * 所有待用"菜单"
     */
    private static List<Permission> all = null;

    /**
     * 转换为树形
     * @param list 所有节点
     * @return 转换后的树结构菜单
     */
    public static List<Permission> toTree(List<Permission> list) {
        // 最初, 所有的 "菜单" 都是待用的
        all = new ArrayList<>(list);

        // 拿到所有的顶级 "菜单"
        List<Permission> roots = new ArrayList<>();

        for (Permission menuTreeVO : list) {
            if (menuTreeVO.getParent() == 0) {
                roots.add(menuTreeVO);
            }
        }

        // 将所有顶级菜单从 "待用菜单列表" 中删除
        all.removeAll(roots);

        for (Permission menuTreeVO : roots) {
            menuTreeVO.setChildren(getCurrentNodeChildren(menuTreeVO));;
        }
        return roots;
    }

    /**
     * 递归函数
     *      递归目的: 拿到子节点
     *      递归终止条件: 没有子节点
     * @param parent 父节点
     * @return  子节点
     */
    private static List<Permission> getCurrentNodeChildren(Permission parent) {
        // 判断当前节点有没有子节点, 没有则创建一个空长度的 List, 有就使用之前已有的所有子节点.
        List<Permission> childList = parent.getChildren() == null ? new ArrayList<>() : parent.getChildren();

        // 从 "待用菜单列表" 中找到当前节点的所有子节点
        for (Permission child : all) {
            if (parent.getId() == (child.getParent())) {
                childList.add(child);
            }
        }

        // 将当前节点的所有子节点从 "待用菜单列表" 中删除
        all.removeAll(childList);

        // 所有的子节点再寻找它们自己的子节点
        for (Permission menuTreeVO : childList) {
            menuTreeVO.setChildren(getCurrentNodeChildren(menuTreeVO));
        }
        return childList;
    }
}
