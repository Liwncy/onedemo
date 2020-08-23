package com.liwncy.system.sysdept.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liwncy.system.sysdept.dao.SysDeptMapper;
import com.liwncy.system.sysdept.model.SysDept;
import com.liwncy.system.sysdept.service.ISysDeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 * InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-26
 */
@Service
@Transactional
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    @Override
    public SysDept getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public boolean update(SysDept entity, Wrapper<SysDept> updateWrapper){
        return super.update(entity,updateWrapper);
    }

    @Override
    public boolean updateById(SysDept entity){
        return super.updateById(entity);
    }

    @Override
    public boolean removeById(Serializable id){
        return super.removeById(id);
    }

    @Override
    public boolean save(SysDept entity) {
        return super.save(entity);
    }
}
