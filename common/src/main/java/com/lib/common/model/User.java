package com.lib.common.model;

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

}

