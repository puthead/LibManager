package com.ygz.library.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel(description = "user")
@TableName("user")
public class User {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "用户id")
	@TableField("u_id")
	private int uId;

	@ApiModelProperty(value = "用户名")
	@TableField("u_name")
	private String uName;

	@ApiModelProperty(value = "密码")
	@TableField("u_Password")
	private String uPassword;



}

