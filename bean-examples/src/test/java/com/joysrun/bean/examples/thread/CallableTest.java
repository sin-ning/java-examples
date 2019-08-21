package com.joysrun.bean.examples.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * author: sin
 * time: 2019-08-20 18:00
 */
public class CallableTest {

    @Test
    public void callableTest() throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Object> future = pool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.err.println("running call...");
                return 100;
            }
        });

        System.err.println("future print: " + future.get());;
    }
}
