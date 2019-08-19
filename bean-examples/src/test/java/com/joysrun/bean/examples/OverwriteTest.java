package com.joysrun.bean.examples;

import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-20 00:26
 */
public class OverwriteTest {

    @Test
    public void overwriteTest() {
        new B().show();
    }

    static class A {

        static {
            System.err.println("a static init...");
        }

        public A() {
            System.err.println("a constructor init...");
        }

        public void show() {
            System.err.println("show a....");
        }

        public void show(String name) {
            System.err.println("overload: show " + name );
        }
    }

    static class B extends A {

        static {
            System.err.println("b static init...");
        }

        public B() {
            System.err.println("B constructor init...");
        }

        @Override
        public void show() {
            super.show();
            System.err.println("show b...");
        }
    }
}
