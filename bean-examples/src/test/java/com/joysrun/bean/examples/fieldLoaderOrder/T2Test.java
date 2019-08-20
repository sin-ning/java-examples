package com.joysrun.bean.examples.fieldLoaderOrder;

import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-20 16:17
 */
public class T2Test {

    public static void main(String[] args) {
//        new FieldLoaderOrderTest();
        new FieldLoaderOrderTest.A1();
//        new A2();


    }
    @Test
    public void t2Test() {
        FieldLoaderOrderTest.A1 a1 = new FieldLoaderOrderTest.A1();
        A2 a2 = new A2();
    }
}
