package com.liwncy.system.sysmenu.service.impl;

import com.liwncy.common.base.service.impl.BaseServiceImpl;
import com.liwncy.system.sysmenu.model.SysMenu;
import com.liwncy.system.sysmenu.dao.SysMenuMapper;
import com.liwncy.system.sysmenu.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统菜单表 服务实现类
 * </p>
 *
 * @author Liwncy
 * @since 2020-08-24
 */
@Service
//public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> {
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

}
