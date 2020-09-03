package com.liwncy.oneexamples.java8exp.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamThree {

    public static void main(String args[]) {
        StreamThree st = new StreamThree();
        List<Student> stus = st.getList();

        System.out.println("//1,查询学生中所有的男生");
        stus.stream().filter(stu -> "1".equals(stu.getSex())).collect(Collectors.toList()).forEach(System.out::println);

        Map<String, List<Student>> group = stus.stream().collect(Collectors.groupingBy(Student::getClassName));
        System.out.println(group);
    }
































    /**
     * 生成学生列表
     * @return
     */
    public List<Student> getList(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"王小明","1",18,"三年级1班"));
        list.add(new Student(2,"张大炮","1",17,"三年级1班"));
        list.add(new Student(3,"李小炮","0",18,"三年级2班"));
        list.add(new Student(4,"王小四","0",19,"四年级1班"));
        list.add(new Student(5,"孙二虎","0",16,"四年级1班"));
        list.add(new Student(6,"赵晓书","1",20,"三年级1班"));
        return list;
    }

    /**
     * 学生类
     */
    @Data
    @AllArgsConstructor
    public class Student {
        //id
        private Integer id;
        //名字
        private String name;
        //性别:0:女,1男;
        private String sex;
        //年龄
        private Integer age;
        //班级
        private String className;
    }
}
