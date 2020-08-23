package com.liwncy.system.sysnotice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liwncy.system.sysnotice.model.SysNotice;
import com.liwncy.system.sysnotice.dao.SysNoticeMapper;
import com.liwncy.system.sysnotice.service.ISysNoticeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * InnoDB free: 9216 kB 服务实现类
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-25
 */
@Service
@Transactional
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements ISysNoticeService {

}
