package com.liwncy.system.sysuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liwncy.system.sysrole.dao.SysRoleMapper;
import com.liwncy.system.sysuser.dao.SysUserMapper;
import com.liwncy.system.sysuser.model.SysUser;
import com.liwncy.system.sysuser.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 * InnoDB free: 9216 kB; (`deptid`) REFER `warehouse/sys_dept`(`id`) ON UPDATE CASC 服务实现类
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-21
 */
@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public boolean save(SysUser entity) {
        return super.save(entity);
    }

    @Override
    public boolean updateById(SysUser entity) {
        return super.updateById(entity);
    }

    @Override
    public SysUser getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public boolean removeById(Serializable id) {
        //根据用户id删除用户角色中间表的数据
        roleMapper.deleteRoleUserByUid(id);
        //删除用户头像[如果是默认头像不删除，否则删除]

        return super.removeById(id);
    }

    /**
     * 保存用户和角色的关系
     * @param uid 用户的ID
     * @param ids 用户拥有的角色的ID的数组
     */
    @Override
    public void saveUserRole(Integer uid, Integer[] ids) {
        //1.根据用户ID删除sys_user_role里面的数据
        roleMapper.deleteRoleUserByUid(uid);
        if (null!=ids&&ids.length>0){
            for (Integer rid : ids) {
                roleMapper.insertUserRole(uid,rid);
            }
        }
    }
}
