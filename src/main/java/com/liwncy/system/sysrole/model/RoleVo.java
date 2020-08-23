package com.liwncy.system.sysrole.model;

import com.liwncy.system.sysrole.model.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: liwncy
 * @Date: 2019/11/28 20:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleVo extends SysRole {

    private Integer page=1;
    private Integer limit=10;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
