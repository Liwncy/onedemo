package com.liwncy.common.base.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Liwncy
 * @since 2019-11-07
 */
//@Service
public interface IBaseService<T> {
    T selectByKey(Serializable key);

    int save(T entity);

    int delete(Serializable key);

    int updateAll(T entity);

    int updateByCondition(T entity, Wrapper<T> updateWrapper) ;

    public IPage<T> selectPageByCondition(IPage<T> page , QueryWrapper<T> selectWrapper);

}
