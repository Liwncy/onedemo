package com.liwncy.oneexample.java8exp.pojo;

import com.liwncy.oneexample.java8exp.reference.ReferenceAte;

/**
 * 车
 *
 * @author: Liwncy
 * @date: 2020-09-28 11:17
 **/
public class Car {
    public static Car create(final ReferenceAte<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}
