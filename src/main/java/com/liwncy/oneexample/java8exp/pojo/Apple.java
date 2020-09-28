package com.liwncy.oneexample.java8exp.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 苹果
 *
 * @author: Liwncy
 * @date: 2020-09-28 09:51
 **/
@Data
public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }
}
