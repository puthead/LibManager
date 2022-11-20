package com.lib.common.res;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
public class ResultJson {

    private Object data;//返回的数据
    private Meta meta;
}
