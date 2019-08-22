package com.joysrun.bean.examples.ReenreantLock;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: sin
 * time: 2019-08-20 20:37
 */
public class BlockQueueDemo {

    private Lock reentrantLock = new ReentrantLock();
    private ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

    private int count = 0;

    public void producer() {
        try {
            queue.put(count++);
            System.err.println("生产者 +1 count: " + queue.size());
            sleep();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void consumer() {
        try {
            queue.take();
            System.err.println("消费者 -1 count: " + queue.size());
            sleep();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private void sleep() {
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Producer implements Runnable {

        private BlockQueueDemo resource;

        public Producer (BlockQueueDemo resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                resource.producer();
            }
        }
    }

    static class Consumer implements Runnable {

        private BlockQueueDemo resource;

        public Consumer(BlockQueueDemo resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                resource.consumer();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BlockQueueDemo resource = new BlockQueueDemo();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        new Thread(producer).start();

        Thread.sleep(1000L);

        new Thread(consumer).start();
        new Thread(consumer).start();

        System.in.read();
    }
}
