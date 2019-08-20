package com.joysrun.bean.examples.fieldLoaderOrder;

import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-20 16:12
 */
public class FieldLoaderOrderTest {

    private static final Integer v1 = 1;
    private Integer v2 = 1;

    public FieldLoaderOrderTest() {
        System.err.println("FieldLoaderOrderTest constructor init...");
    }

    static {
        System.err.println("FieldLoaderOrderTest static {} init...");
    }

    static class A1 {

        {
            System.err.println("A1 static {} init...");
            System.err.println(v1);
            System.err.println(A11.count);
            System.err.println(A11.count2);
        }

        public A1() {
            System.err.println("A1 constructor init...");
        }
    }

    static class A11 {
        public static final int count = 200;

        public static int count2 = 200;

        {
            count2 = 300;
            System.err.println("A11 static {} init...");
        }

        public A11() {
            System.err.println("A11 init...");
        }
    }


    public class A3 {

        public static final int count = 100;

        public A3() {
            System.err.println("A1 constructor init...");
        }
    }

}

class A2 {

    static {
        System.err.println("A1 static {} init...");
    }

    public A2() {
        System.err.println("A1 constructor init...");
    }
}