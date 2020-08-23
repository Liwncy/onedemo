package com.liwncy.system.sysdept.model;

import com.liwncy.system.sysdept.model.SysDept;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: liwncy
 * @Date: 2019/11/26 11:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DeptVo extends SysDept {

    private Integer page=1;
    private Integer limit=10;

}
