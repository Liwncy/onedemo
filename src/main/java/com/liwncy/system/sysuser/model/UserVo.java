package com.liwncy.system.sysuser.model;

import com.liwncy.system.sysuser.model.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: liwncy
 * @Date: 2019/12/2 8:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserVo extends SysUser {

    private Integer page=1;
    private Integer limit=10;

    /**
     * 验证码
     */
    private String code;
}
