package com.joysrun.bean.examples.ReenreantLock;

import java.io.IOException;

/**
 * author: sin
 * time: 2019-08-20 20:37
 */
public class Resource {

    private int count = 0;
    private boolean flag = false;

    public synchronized void producer() {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;
        notify();
        count++;
        System.err.println("生产者 +1 count: " + count);

        sleep();
    }

    public synchronized void consumer() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
        count--;
        notify();
        System.err.println("生产者 -1 count: " + count);

        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Producer implements Runnable {

        private Resource resource;

        public Producer (Resource resource) {
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

        private Resource resource;

        public Consumer(Resource resource) {
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
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

        new Thread(producer).start();
        new Thread(consumer).start();

        System.in.read();
    }
}
