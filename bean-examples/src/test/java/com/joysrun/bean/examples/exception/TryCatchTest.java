package com.joysrun.bean.examples.exception;

import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-23 14:01
 */
public class TryCatchTest {

    @Test
    public void finallyTest() {
//        System.err.println("result: " + finallyFun(1));
        System.err.println("result: " + finallyFun(2));
    }


    private Integer finallyFun(int k) {
        int res = 0;
        try {
            switch (k) {
                case 1:
                    System.err.println("switch 1");
                    res = 1;
                    break;
                case 2:
                    System.err.println("switch 2");
                    res = 2;
                case 3:
                    System.err.println("switch 3");
                    res = 3;
                    break;
                default:
                    System.err.println("switch default");
                    res = 10;
            }
            return res;
        } catch (Exception e) {
            System.err.println("exception...");
        } finally {
            System.err.println("finally..");
            res = 100;
            return res;
        }
    }
}
