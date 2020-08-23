package com.liwncy.system.sysloginfo.model;

import com.liwncy.system.sysloginfo.model.SysLoginfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: liwncy
 * @Date: 2019/11/23 18:19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginfoVo extends SysLoginfo {

    private Integer page=1;
    private Integer limit=10;

    //接收多个id
    private Integer[] ids;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
