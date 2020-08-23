package com.liwncy.system.sysuser.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * InnoDB free: 9216 kB; (`deptid`) REFER `warehouse/sys_dept`(`id`) ON UPDATE CASC
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
@ToString
public class SysUserVo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptname;


}
