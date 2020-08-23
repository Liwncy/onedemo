package com.liwncy.system.sysuser.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liwncy.system.sysuser.model.SysUser;

/**
 * <p>
 * InnoDB free: 9216 kB; (`deptid`) REFER `warehouse/sys_dept`(`id`) ON UPDATE CASC 服务类
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-21
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 保存用户和角色的关系
     * @param uid 用户的ID
     * @param ids 用户拥有的角色的ID的数组
     */
    void saveUserRole(Integer uid, Integer[] ids);
}
