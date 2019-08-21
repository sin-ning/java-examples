package com.joysrun.bean.examples.threadPool;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: sin
 * time: 2019-08-20 17:54
 */
public class ThreadPoolTest {

    @Test
    public void fixedThreadPoolTest() {
        try {
            ExecutorService pool = Executors.newFixedThreadPool(5);

            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.err.println("task run...");
                }
            });

            // 防止退出
            System.err.println("system in...");
            System.in.read();
            System.err.println("system done...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.err.println("finally...");
        }
    }
}
