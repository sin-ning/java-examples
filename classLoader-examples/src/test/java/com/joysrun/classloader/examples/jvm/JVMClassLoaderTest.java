package com.joysrun.classloader.examples.jvm;

import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-17 23:55
 */
public class JVMClassLoaderTest {

    @Test
    public void staticFinalTest() {
        System.err.println(JVMClassA.count);
    }

    @Test
    public void final2Test() {
        System.err.println(new JVMClassA().count2);
    }
}
