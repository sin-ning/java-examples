package com.joysrun.bean.examples.ReenreantLock;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: sin
 * time: 2019-08-20 20:37
 */
public class Resource3 {

    private int count = 0;
    private int maxCount = 10;
    private boolean flag = false;

    private Lock reentrantLock = new ReentrantLock();
    private Condition producerCondition = reentrantLock.newCondition();
    private Condition consumerCondition = reentrantLock.newCondition();

    public void producer() {
        reentrantLock.lock();
        try {
            if (flag) {
                try {
                    producerCondition.await();
                    System.err.println("producer await...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            if (count >= maxCount) {
                flag = true;
                consumerCondition.signalAll();
            }
            System.err.println("生产者 +1 count: " + count);
            sleep();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void consumer() {
        reentrantLock.lock();
        try {
            if (!flag) {
                try {
                    consumerCondition.await();
                    System.err.println("consumer await...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            if (count <= 1) {
                flag = false;
                producerCondition.signalAll();
            }
            System.err.println("消费者 -1 count: " + count);
            sleep();
        } finally {
            reentrantLock.unlock();
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

        private Resource3 resource;

        public Producer (Resource3 resource) {
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

        private Resource3 resource;

        public Consumer(Resource3 resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                resource.consumer();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Resource3 resource = new Resource3();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        new Thread(producer).start();
        new Thread(consumer).start();

        System.in.read();
    }
}
