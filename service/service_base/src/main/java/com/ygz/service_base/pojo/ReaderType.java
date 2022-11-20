package com.ygz.service_base.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("readertype")
public class ReaderType implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String readerType;
    private double timeoutFine;
}
