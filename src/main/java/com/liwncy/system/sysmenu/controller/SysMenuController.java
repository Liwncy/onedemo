package com.liwncy.system.sysmenu.controller;

import com.liwncy.system.sysmenu.service.impl.SysMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统菜单表 前端控制器
 * </p>
 *
 * @author Liwncy
 * @since 2020-08-24
 */
@RestController
@RequestMapping("/sysmenu")
public class SysMenuController {
    @Autowired
    SysMenuServiceImpl sysMenuService;
}

