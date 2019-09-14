package com.joysrun.design.pattern.examples;

/**
 * 原型设计模式
 *
 * author: sin
 * time: 2019/9/14 4:15 下午
 */
public class Prototype implements Cloneable {

    private static Prototype defaultPrototype = new Prototype();

    public static Prototype getInstance() {
        try {
            return (Prototype) defaultPrototype.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Prototype getDefaultPrototype() {
        return defaultPrototype;
    }

    public static void main(String[] args) {
        getInstance();
        long now = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Prototype prototype = new Prototype();
//            Prototype prototype = getInstance();
        }
        System.err.println("耗时: " + (System.currentTimeMillis() - now));
        System.err.println("default has request ? " + getDefaultPrototype().equals(getInstance()));
    }
}
