package com.liwncy.system.syspermisson.model;

import com.liwncy.system.syspermisson.model.SysPermission;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: liwncy
 * @Date: 2019/11/22 15:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionVo extends SysPermission {

    private Integer page=1;
    private Integer limit=10;
}
