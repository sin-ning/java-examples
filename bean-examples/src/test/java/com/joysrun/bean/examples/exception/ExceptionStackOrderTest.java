package com.joysrun.bean.examples.exception;

import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-23 16:04
 */
public class ExceptionStackOrderTest {

    @Test
    public void stackOrderTest() {
        try {
            new B().bF1();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new B().bF1();
        } catch (Throwable e) {
            for (StackTraceElement ste : e.getStackTrace()){
                System.out.println(ste.getMethodName());
            }
            e.printStackTrace();
        }
    }

    static class Hello {
        public void hF1() throws Exception {
            throw new Exception();
        }
    }

    static class A {
        public void aF1() throws Throwable {
            try {
                new Hello().hF1();
            } catch (Exception e) {
                throw e.fillInStackTrace();
            }
        }
    }

    static class B {
        public void bF1() throws Throwable {
            try {
                new A().aF1();
            } catch (Exception e) {
                throw e.fillInStackTrace();
            }
        }
    }
}
