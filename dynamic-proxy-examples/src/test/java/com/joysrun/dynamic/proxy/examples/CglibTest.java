package com.joysrun.dynamic.proxy.examples;

import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * author: sin
 * time: 2019-08-19 18:30
 */
public class CglibTest {

    @Test
    public void cglibTest() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/sin/Downloads/debug");
        Hello hello = (Hello) Enhancer.create(Hello.class, new HelloMethodInterceptor());
        hello.hello();
    }

    static class Hello {

        public void hello() {
            System.err.println("hello...");
        }
    }

    static class HelloMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.err.println("before...");
            Object result = methodProxy.invokeSuper(o, objects);
            System.err.println("after...");
            return result;
        }
    }
}
