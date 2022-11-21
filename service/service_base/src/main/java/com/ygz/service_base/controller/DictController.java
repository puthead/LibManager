package com.ygz.service_base.controller;

import com.lib.common.model.Dict;
import com.lib.common.res.Meta;
import com.lib.common.res.ResultJson;
import com.ygz.service_base.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/base")
@Slf4j
public class DictController {
    @Autowired
    DictService dictService;

    @GetMapping("dict")
    public ResultJson getDicts(){
        List<Dict> dicts =dictService.getDicts();
        return new ResultJson().setMeta(new Meta().setStatus(200).setMsg("查询数据字典成功")).setData(dicts);
    }
}
