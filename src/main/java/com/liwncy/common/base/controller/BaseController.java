package com.liwncy.common.base.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liwncy.common.base.model.CommonResult;
import com.liwncy.common.base.model.QueryParam;
import com.liwncy.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 通用Controller
 *
 * @param <T> 实体
 */
@RestController
public abstract class BaseController<T> {

    @Autowired
    private BaseServiceImpl<T> baseService;

    public abstract BaseServiceImpl<T> getBaseService() ;
    @ResponseBody
    @RequestMapping(value = "/listpages")
    public Object listByPage(T t,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(name = "queryParams", required = false)  List <QueryParam> queryParams
    ) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<T>();
        IPage<T> p=  baseService.selectPageByCondition(new Page<T>(pageNum,pageSize), queryWrapper);
        return new CommonResult().pageSuccess(p);
    }
}
