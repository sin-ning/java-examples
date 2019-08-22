package com.joysrun.bean.examples.threadPool;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * author: sin
 * time: 2019-08-22 13:37
 */
public class CacheThreadPoolTest {

    static class Task1 implements Runnable {

        @Override
        public void run() {
            System.err.println(Thread.currentThread().getName() + " --> ");
        }
    }

    @Test
    public void cacheThreadPool2Test() throws IOException {
        ExecutorService executorService = new ThreadPoolExecutor(
                2, 10, 3L,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));

        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task1());
        }

        System.in.read();
    }

    @Test
    public void cacheThreadPoolTest() {
        Executor executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executor.execute(new Task1());
        }
    }
}
