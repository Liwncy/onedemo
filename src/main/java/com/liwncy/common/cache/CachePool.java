package com.liwncy.common.cache;

import com.liwncy.common.utils.SpringUtil;
import com.liwncy.system.sysdept.dao.SysDeptMapper;
import com.liwncy.system.sysdept.model.SysDept;
import com.liwncy.system.sysuser.dao.SysUserMapper;
import com.liwncy.system.sysuser.model.SysUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liwncy
 * @Date: 2019/12/20 18:05
 */
public class CachePool {

    /**
     * 所有的缓存数据放到这个CACHE_CONTAINER类似于redis
     */
    public static volatile Map<String,Object> CACHE_CONTAINER = new HashMap<>();

    /**
     * 根据KEY删除缓存
     * @param key
     */
    public static void removeCacheByKey(String key){
        if (CACHE_CONTAINER.containsKey(key)){
            CACHE_CONTAINER.remove(key);
        }
    }

    /**
     * 清空所有缓存
     */
    public static void removeAll(){
        CACHE_CONTAINER.clear();
    }

    /**
     * 同步缓存
     */
    public static void syncData(){
        //同步部门数据
        SysDeptMapper deptMapper = SpringUtil.getBean(SysDeptMapper.class);
        List<SysDept> deptList = deptMapper.selectList(null);
        for (SysDept dept : deptList) {
            CACHE_CONTAINER.put("dept:"+dept.getId(),dept);
        }
        //同步用户数据
        SysUserMapper userMapper = SpringUtil.getBean(SysUserMapper.class);
        List<SysUser> userList = userMapper.selectList(null);
        for (SysUser user : userList) {
            CACHE_CONTAINER.put("user:"+user.getId(),user);
        }
    }


}
