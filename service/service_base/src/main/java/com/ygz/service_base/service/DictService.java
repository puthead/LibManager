package com.ygz.service_base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lib.common.model.Dict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DictService extends IService<Dict> {
    List<Dict> getDicts();
}
