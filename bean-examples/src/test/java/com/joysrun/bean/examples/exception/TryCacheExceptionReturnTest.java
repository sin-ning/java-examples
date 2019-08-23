package com.joysrun.bean.examples.exception;

import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-23 20:18
 */
public class TryCacheExceptionReturnTest {

    @Test
    public void exceptionReturnTest() {
        System.err.println(new TryCacheExceptionReturnTest().getCount());;
    }


    private int getCount() {
        try {
            throw new RuntimeException("hh");
        } catch (Exception e) {
            return -1;
        } finally {
            return 100;
        }
    }
}
