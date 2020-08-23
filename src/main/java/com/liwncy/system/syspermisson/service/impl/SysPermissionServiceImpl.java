package com.liwncy.system.syspermisson.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liwncy.system.syspermisson.dao.SysPermissionMapper;
import com.liwncy.system.syspermisson.model.SysPermission;
import com.liwncy.system.syspermisson.service.ISysPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 * InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-22
 */
@Service
@Transactional
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Override
    public boolean removeById(Serializable id) {

        //根据权限ID或菜单ID删除sys_role_permission表中的数据
        SysPermissionMapper permissionMapper = this.getBaseMapper();
        permissionMapper.deleteRolePermissionByPid(id);
        //删除权限表中的数据
        return super.removeById(id);
    }
}
