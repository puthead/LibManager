package com.ygz.library.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@TableName("book")
public class Book implements Serializable {


	private static final long serialVersionUID = 1L;
	

	private int bId;


	private String bName;


	private String ISBN;

	private String bQuantity;

	private int bStatus;

}

