package com.joysrun.bean.examples.oop;

/**
 * author: sin
 * time: 2019-08-20 00:06
 */
public class Student extends Person {

    public String school;

    public void studentShow() {
        System.err.println("student show...");
    }

    @Override
    public String toString() {
        return "Student{" +
                "school='" + school + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
