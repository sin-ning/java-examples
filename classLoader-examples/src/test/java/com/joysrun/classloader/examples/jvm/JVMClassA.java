package com.joysrun.classloader.examples.jvm;

/**
 * author: sin
 * time: 2019-08-17 23:56
 */
public class JVMClassA {

    public static final int count = 10;

    public final int count2;
//
//    static {
//        count2 = 30;
//    }

    public JVMClassA() {
        count2 = 30;
        System.err.println("init.... " + this.getClass().getName());
    }
}
