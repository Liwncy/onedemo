package com.liwncy.oneexample.java8exp.stream;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liwncy.system.sysdept.model.SysDept;
import com.liwncy.system.sysuser.model.SysUser;
import com.liwncy.system.sysuser.model.SysUserVo;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBte {
    public static void main(String[] args) {
        // 0,定义userList
        List<SysUser> userList = new ArrayList<>();
        QueryWrapper<SysUser> eq = new QueryWrapper();
        eq.lambda()
                .eq(SysUser::getId, "12")
                .or(i -> i.eq(SysUser::getId, "100").eq(SysUser::getPwd, "123"))
                .eq(SysUser::getName, "343");

        for (int i = 1; i <= 20; i++) {
            SysUser user = new SysUser();
            user.setId(i);
            user.setName("姓名" + i);
            userList.add(user);
        }
        System.out.println("使用 Java 8: ");
        System.out.println("列表: " + userList.toString());
        // 1,forEach 迭代
        userList.stream().limit(10).forEach(System.out::println);

        // 2,map 映射
        userList.stream()
                .map(user -> user.setDeptname("部门" + user.getId()))
                .collect(Collectors.toList());

        // 3,filter 筛选
        List<SysUser> filtered = userList.stream()
                .filter(user -> user.getId() == 9)
                .collect(Collectors.toList());
        System.out.println("筛选ID为9的数据有: " + filtered);

        // 4,limit:前几条数据 skip:跳过几条到最后
        List<SysUser> someUserList = userList.stream()
                .skip(10)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("第10-15的数据有: " + someUserList);

        // 5,sorted:排序
        List<SysUser> sortedList = userList.stream()
                .sorted(Comparator.comparing(SysUser::getId).reversed())
                .collect(Collectors.toList());
        System.out.println("按ID倒序排列后的列表为:" + sortedList);
        String[] arr = new String[]{"1", "2", "3"};
        String mergedString = userList.stream()
                .filter(user -> ArrayUtils.contains(arr, user.getId().toString()))
                .sorted(Comparator.comparing(SysUser::getId).reversed())
                .map(user -> user.getId().toString()).collect(Collectors.toList())
                .stream().collect(Collectors.joining(","));
        System.out.println("筛选id不为1,获取所有ID,合并ID字符串: " + mergedString);

        //List<SysUser> squaresList = userList.stream().map(user -> user.setDeptname("禁部")).distinct().collect(Collectors.toList());
        List<SysUser> squaresList = userList.stream()
                .map(user -> user.setDeptname("禁部").setName("金低啊"))
                .distinct()
                .collect(Collectors.toList());
        List<SysDept> deptList = userList.stream()
                .map(StreamBte::userToDept)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("SquaresList: " + squaresList);
        System.out.println("deptList:" + deptList);
        List<SysUserVo> exlisted = userList.stream()
                .map(StreamBte::userToUserVo)
                .collect(Collectors.toList());
        System.out.println("userVoList:" + exlisted);
//        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
//        System.out.println("列表: " + integers);
//
//        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
//
//        System.out.println("列表中最大的数 : " + stats.getMax());
//        System.out.println("列表中最小的数 : " + stats.getMin());
//        System.out.println("所有数之和 : " + stats.getSum());
//        System.out.println("平均数 : " + stats.getAverage());
//        System.out.println("随机数: ");
//
//        random.ints().limit(10).sorted().forEach(System.out::println);
//
//        // 并行处理
//        count = strings.parallelStream().filter(string -> string.isEmpty()).count();
//        System.out.println("空字符串的数量为: " + count);
    }

    private static SysDept userToDept(SysUser sysUser) {
        SysDept dept = new SysDept();
        dept.setId(sysUser.getId());
        dept.setName(sysUser.getDeptname());
        return dept;
    }

    private static SysUserVo userToUserVo(SysUser user) {
        SysUserVo userVo = new SysUserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }
}
