package com.liwncy.system.sysloginfo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liwncy.system.sysloginfo.dao.SysLoginfoMapper;
import com.liwncy.system.sysloginfo.model.SysLoginfo;
import com.liwncy.system.sysloginfo.service.ISysLoginfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-23
 */
@Service
@Transactional
public class SysLoginfoServiceImpl extends ServiceImpl<SysLoginfoMapper, SysLoginfo> implements ISysLoginfoService {

}
