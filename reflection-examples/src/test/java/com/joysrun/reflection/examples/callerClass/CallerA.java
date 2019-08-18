package com.joysrun.reflection.examples.callerClass;

/**
 * author: sin
 * time: 2019-08-18 13:05
 */
public class CallerA implements CallerAPI {

    public static int i = 0;

    static {
        System.err.println("static {} init...");
    }

    public static class B {

        public static final int i = 0;

        static {
            System.err.println("b static {} init...");
        }
    }

    @Override
    public void caller() {
        new CallerB().caller();
    }
}
