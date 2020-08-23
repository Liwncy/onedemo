package com.liwncy.system.syspermisson.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liwncy.system.syspermisson.model.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * InnoDB free: 9216 kB Mapper 接口
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-22
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 根据权限ID或菜单ID删除sys_role_permission表里面的数据
     * @param id
     */
    void deleteRolePermissionByPid(@Param("id") Serializable id);
}
