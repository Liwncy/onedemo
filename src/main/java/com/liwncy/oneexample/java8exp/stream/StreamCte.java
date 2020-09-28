package com.liwncy.oneexample.java8exp.stream;

import com.liwncy.oneexample.java8exp.pojo.Apple;
import org.jsoup.select.Collector;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * Stream测试例子
 * Java8 快速实现List转map 、分组、过滤等操作
 *
 * @author: Liwncy
 * @date: 2020-09-28 09:51
 **/
public class StreamCte {
    public static void main(String[] args) {
        List<Apple> aList = getList();
        // 1,分组
        Map<Integer, List<Apple>> groupBy = aList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println("Group:" + groupBy);
        // 2,List转Map
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         * apple1,apple12的id都为1。
         * 可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Apple> aMap = aList.stream().collect(Collectors.toMap(Apple::getId, a -> a, (k1, k2) -> k1));
        System.out.println("Map:" + aMap);
        // 3,过滤Filter
        List<Apple> fList = aList.stream().filter(a -> a.getId() == 1).collect(Collectors.toList());
        System.out.println("Filtered:" + fList);
        // 4,求和
        BigDecimal totalMoney = aList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        Integer totalId = aList.stream().map(Apple::getId).reduce(0, Integer::sum);
        System.out.println("total:" + totalMoney);
        System.out.println("total:" + totalId);
        // 5,查找流中最大 最小值
        Optional<Apple> maxA = aList.stream().collect(Collectors.maxBy(Comparator.comparing(Apple::getId)));
        maxA.ifPresent(System.out::println);

        Optional<Apple> minA = aList.stream().
                collect(Collectors.minBy(Comparator.comparing(Apple::getName)));
        minA.ifPresent(System.out::println);
        // 6,去重
        //// 根据字段去重
        List<Apple> unique = aList.stream().collect(
                collectingAndThen(toCollection(() -> new TreeSet<>(comparingLong(Apple::getId))), ArrayList::new)
        );
        System.out.println(unique);
        //// distinct去除相同数据()
        aList.add(new Apple(3, "荔枝", new BigDecimal("9.99"), 40));
        List<Apple> unique2 = aList.stream().distinct().collect(Collectors.toList());
        System.out.println(unique2);
        //// 根据字段去重(filter实现)
        List<Integer> ids = new ArrayList<>();
        List<Apple> unique3 = aList.stream().filter(
            v -> {
                boolean flag = !ids.contains(v.getId());
                ids.add(v.getId());
                return flag;
            }
        ).collect(Collectors.toList());
        System.out.println(unique3);
    }

    public static List<Apple> getList() {
        List<Apple> appleList = new ArrayList<>();

        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        return appleList;
    }
}
