package com.joysrun.bean.examples.exception;

import java.io.IOException;
import java.io.InterruptedIOException;

/**
 * author: sin
 * time: 2019-08-23 19:24
 */
public class ExceptionExtendsTest2 {

    class Test {
        public Test() throws IOException {
        }

        void test() throws IOException, Exception {
        }
    }

    interface I1 {
        void test() throws Exception;
    }

    class SubTest extends Test implements I1 {
        public SubTest() throws Exception, NullPointerException, NoSuchMethodException {
        }

        @Override
        public void test() {

        }
    }
}
