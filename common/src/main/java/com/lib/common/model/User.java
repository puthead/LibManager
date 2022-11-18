package com.lib.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@TableName("user")
@Accessors(chain = true)
public class User implements Serializable {


	private static final long serialVersionUID = 1L;
	

	private int uId;


	private String uName;


	private String uPassword;

	@TableField(exist = false)
	private Long loginTime ;

	/**
	 * 令牌过期时间
	 * */
	@TableField(exist = false)
	private Long expireTime ;


}

