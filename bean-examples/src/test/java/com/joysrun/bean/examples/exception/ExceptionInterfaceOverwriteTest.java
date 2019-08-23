package com.joysrun.bean.examples.exception;

import org.junit.Test;
import org.omg.SendingContext.RunTime;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * author: sin
 * time: 2019-08-23 18:13
 */
public class ExceptionInterfaceOverwriteTest {

    @Test
    public void exceptionTest() {
        try {
            // interface 方法声名的 throws 异常，子类实现可以不遵循 接口的声名。
            new B().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static interface A {

        public void show() throws IOException;
    }

    static class B implements A {

        @Override
        public void show() throws IOException {
            System.err.println("B");
        }
    }
}
