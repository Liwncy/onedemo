package com.liwncy.system.sysmenu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liwncy.system.sysmenu.model.SysMenu;
import com.liwncy.system.sysmenu.service.ISysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主产品销售情况控制器
 *
 * @author Liwncy
 * @Date 2019-11-07 16:28:23
 */
@Controller
@RequestMapping("/sysmenu")
public class SysMenuController {

    private String PREFIX = "/sysmenu/sysmenu/";

    @Autowired
    private ISysMenuService sysmenuService;

    @RequestMapping("/login")
    public String index(Model model) {
        List<SysMenu> sysMenus = new ArrayList<>();
//        for (int i = 0; i<5;i++){
//            SysMenu sysMenu = new SysMenu();
//            sysMenu.setId("123"+i);
//            sysMenu.setName("菜单"+i);
//            sysMenus.add(sysMenu);
//        }
//        QueryWrapper<SysMenu> qw = new QueryWrapper();
//        SysMenu sysMenu = sysmenuService.getOne(qw);
        sysMenus = sysmenuService.list();
        model.addAttribute("menus", sysMenus);
        return "userInfo.html";
    }

    /**
     * 跳转到主产品销售情况首页
     */
    @RequestMapping("/view/{ptype}")
    public String index2(@PathVariable String ptype, Model model) {
        model.addAttribute("ptype", ptype);
        return PREFIX + "sysmenu.html";
    }
    /**
     * 跳转到主产品销售情况领导驾驶舱首页
     */
    @RequestMapping("/view_lead")
    public String index_lead(Model model) {
        return PREFIX + "Sysmenu_lead.html";
    }
    /**
     * 跳转到添加主产品销售情况
     */
    @RequestMapping("/Sysmenu_add/{ptype}")
    public String SysmenuAdd(@PathVariable String ptype, Model model) {
        model.addAttribute("ptype", ptype);
        return PREFIX + "Sysmenu_add.html";
    }

    /**
     * 跳转到修改主产品销售情况
     */
    @RequestMapping("/Sysmenu_update/{SysmenuId}")
    public String SysmenuUpdate(@PathVariable String SysmenuId, Model model) {
        return PREFIX + "Sysmenu_edit.html";
    }
    

    /**
     * 获取主产品销售情况列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String sPType,
                       String sDateStatus,
                       String sProductName,
                       @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
                       @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        Page<SysMenu> page = new Page<>(pageNumber, pageSize);
        List<SysMenu> list = new ArrayList<>();
        Map<String, Object> result = new HashMap<>(5);
        result.put("total", page.getTotal());
        result.put("rows", list);
        return result;
    }

    /**
     * 新增主产品销售情况
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(SysMenu Sysmenu) {
        return "SUCCESS_TIP";
    }

    /**
     * 删除主产品销售情况
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestBody List<String> delIds) {
        return "SUCCESS_TIP";
    }

    /**
     * 修改主产品销售情况
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SysMenu Sysmenu) {
        return "SUCCESS_TIP";
    }
}
