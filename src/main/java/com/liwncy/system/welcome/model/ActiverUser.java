package com.liwncy.system.welcome.model;

import com.liwncy.system.sysuser.model.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: liwncy
 * @Date: 2019/11/21 20:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiverUser {

    private SysUser user;

    private List<String> roles;

    private List<String> permission;

}
