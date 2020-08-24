package com.liwncy.common.base.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BaseEntity implements Serializable {
    @TableField("CREATE_TIME")
    private Date createTime = new Date();
    @TableField("CREATE_USER")
    private String createUser;
    @TableField("UPDATE_TIME")
    private Date updateTime;
    @TableField("UPDATE_USER")
    private String updateUser;
    @Version
    @TableField("RECORD_VERSION")
    private Integer recordVersion = 0;

    public BaseEntity() {
    }

    public Date getCreateTime() {
        return createTime;
    }
}

