package com.joysrun.bean.examples.objectMonitor;

import org.junit.Test;

/**
 * author: sin
 * time: 2019-08-21 22:24
 */
public class ObjectMonitorTest {

    private static String name = "1";

    @Test
    public void monitorTest() {

        // .class 获取类文件的 Monitor
        synchronized(ObjectMonitorTest.class) {
            System.err.println("11");
        }
        // 如下一致
        synchronized(name) {
            System.err.println("11");
        }

        // 锁定是当前 new 对象
        synchronized (this) {

        }
    }
}
