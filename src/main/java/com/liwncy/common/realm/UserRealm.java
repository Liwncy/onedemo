package com.liwncy.common.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liwncy.common.constants.Constast;
import com.liwncy.system.syspermisson.model.SysPermission;
import com.liwncy.system.syspermisson.service.ISysPermissionService;
import com.liwncy.system.sysrole.service.ISysRoleService;
import com.liwncy.system.sysuser.model.SysUser;
import com.liwncy.system.sysuser.service.ISysUserService;
import com.liwncy.system.welcome.model.ActiverUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: liwncy
 * @Date: 2019/11/21 20:44
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    /**
     * 当需要使用的时候，才加载。  即：当CacheAspect被解析之后，userService才会解析，要不然切面会不生效
     */
    @Lazy
    private ISysUserService userService;

    @Autowired
    @Lazy
    private ISysPermissionService permissionService;

    @Autowired
    @Lazy
    private ISysRoleService roleService;

    @Override
    public String getName(){
        return this.getClass().getSimpleName();
    }
    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginname",authenticationToken.getPrincipal().toString());
        //通过用户名从数据库中查询出该用户
        SysUser user = userService.getOne(queryWrapper);
        if (null!=user){
            ActiverUser activerUser = new ActiverUser();
            activerUser.setUser(user);

            //根据用户ID查询percode
            QueryWrapper<SysPermission> qw = new QueryWrapper<>();
            //设置只能查询菜单
            qw.eq("type", Constast.TYPE_PERMISSION);
            //设置只能查询可用的菜单
            qw.eq("available",Constast.AVAILABLE_TRUE);
            Integer userId = user.getId();
            //根据用户ID查询角色ID
            List<Integer> currentUserRoleIds = roleService.queryUserRoleIdsByUid(userId);
            //根据角色ID查询出权限ID
            Set<Integer> pids = new HashSet<>();
            for (Integer rid : currentUserRoleIds) {
                List<Integer> permissionIds = roleService.queryRolePermissionIdsByRid(rid);
                pids.addAll(permissionIds);
            }
            List<SysPermission> list = new ArrayList<>();
            if (pids.size()>0){
                qw.in("id",pids);
                list = permissionService.list(qw);
            }
            List<String> percodes = new ArrayList<>();
            for (SysPermission permission : list) {
                percodes.add(permission.getPercode());
            }
            //放到activerUser
            activerUser.setPermission(percodes);

            //生成盐
            ByteSource credentialsSalt= ByteSource.Util.bytes(user.getSalt());
            /**
             * 参数说明：
             * 参数1：活动的User
             * 参数2：从数据库里面查询出来的密码(已经通过MD5加密)
             * 参数3：从数据库里面查询出来的盐
             * 参数4：当前类名
             */
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activerUser,user.getPwd(),credentialsSalt,this.getName());
            return info;
        }
        return null;
    }
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        ActiverUser activerUser = (ActiverUser) principalCollection.getPrimaryPrincipal();
        SysUser user = activerUser.getUser();
        List<String> superPermission = new ArrayList<>();
        superPermission.add("*:*");
        List<String> permissions = activerUser.getPermission();
        if (user.getType().equals(Constast.USER_TYPE_SUPER)){
            authorizationInfo.addStringPermissions(superPermission);
        }else {
            if (null!=permissions&&permissions.size()>0){
                authorizationInfo.addStringPermissions(permissions);
            }
        }
        return authorizationInfo;
    }


}
