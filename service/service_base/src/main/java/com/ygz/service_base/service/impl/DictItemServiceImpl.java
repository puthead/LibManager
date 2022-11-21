package com.ygz.service_base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lib.common.model.DictItem;
import com.ygz.service_base.mapper.DictItemMapper;
import com.ygz.service_base.service.DictItemService;
import org.springframework.stereotype.Service;

@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {
}
