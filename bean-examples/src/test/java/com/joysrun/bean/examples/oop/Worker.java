package com.joysrun.bean.examples.oop;

/**
 * author: sin
 * time: 2019-08-20 00:06
 */
public class Worker extends Person {

    public String work;

    @Override
    public String toString() {
        return "Worker{" +
                "work='" + work + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
