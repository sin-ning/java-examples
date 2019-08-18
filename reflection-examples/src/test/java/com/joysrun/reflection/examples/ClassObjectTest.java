package com.joysrun.reflection.examples;

import com.joysrun.reflection.examples.callerClass.CallerA;
import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-18 14:30
 */
public class ClassObjectTest {

    @Test
    public void classTest() throws ClassNotFoundException {
        // 不会初始化 Class
        System.err.println(CallerA.class);
        // 默认会初始化 Class
        System.err.println(Class.forName("com.joysrun.reflection.examples.callerClass.CallerA"));
        // 可以指定：initialize=false 就不会初始化
        System.err.println(Class.forName("com.joysrun.reflection.examples.callerClass.CallerA", false, ClassLoader.getSystemClassLoader()));
    }
}
