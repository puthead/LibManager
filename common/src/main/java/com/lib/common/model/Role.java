package com.lib.common.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@TableName("role")
@Accessors(chain = true)
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    private int roleId;

    private String roleName;

    private String roleDesc;
}
