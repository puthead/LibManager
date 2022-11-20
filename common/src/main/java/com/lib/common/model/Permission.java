package com.lib.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("permission")
@Accessors(chain = true)
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String authName;
    private String path;
    private int parent;
    private int type;
    private int orderRank;

    @TableField (exist = false)
    private List<Permission> children;
}
