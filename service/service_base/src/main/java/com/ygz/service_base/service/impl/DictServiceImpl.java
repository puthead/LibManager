package com.ygz.service_base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lib.common.model.Dict;
import com.ygz.service_base.mapper.DictMapper;
import com.ygz.service_base.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Autowired
    DictMapper dictMapper;
    @Override
    public List<Dict> getDicts() {
        List<Dict> dicts=dictMapper.selectList(null);
        return dicts;
    }
}
