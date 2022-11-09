package com.ygz.library.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@ApiModel(description = "user")
@TableName("user")
public class User implements Serializable {


	private static final long serialVersionUID = 1L;
	

	private int uId;


	private String uName;


	private String uPassword;



}

