package com.liwncy.oneexamples;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.liwncy.oneexamples.javacexp.reptile.GithubCom;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
//    public static void main(String args[]){
//        Integer a = 1000, b = 1000;
//        System.out.println(a.equals(b));
//        Integer c = 100, d = 100;
//        System.out.println(c.equals(d));
//        System.out.println(1000==1000);
//    }

//    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//
//        Class cache = Integer.class.getDeclaredClasses()[0];
//        Field myCache = cache.getDeclaredField("cache");
//        myCache.setAccessible(true);
//
//        Integer[] newCache = (Integer[]) myCache.get(cache);
//        newCache[132] = newCache[133];
//
//        int a = 2;
//        int b = a + a;
//        System.out.printf("%d + %d = %d", a, a, b);
//    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        学生 学生0 = new 学生();
        学生0.set姓名("张三");
        helloWorld.学生说话(学生0,"你好,世界!");
    }

    public void 学生说话(学生 学生0 ,String 文字){
        System.out.println(学生0.get姓名()+"说:"+文字);
    }

    /**
     * 学生类
     */
    @Data
    public static class 学生 {
        String 姓名;
        String 年龄;
    }
}
