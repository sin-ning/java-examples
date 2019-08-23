package com.joysrun.bean.examples.exception;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * author: sin
 * time: 2019-08-23 18:13
 */
public class ExceptionExtendsOverwriteTest {

    @Test
    public void exceptionTest() {
        try {
            // throws 的异常声名，可以不按父类的来，也算重写
            new B().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class A {

        public void show() throws IOException {
            System.err.println("A");
        }
    }

    static class B extends A {

        @Override
        public void show() throws IOException, FileNotFoundException {
            System.err.println("B");
        }
    }
}
