package com.joysrun.bean.examples.thread;

import java.io.IOException;

/**
 * author: sin
 * time: 2019-08-20 18:54
 */
public class ThreadDemo2 {

    private static int number = 0;

    private static int maxNumber = 10;

    static class Producer implements Runnable {

        @Override
        public void run() {
            for (;;) {
                System.err.println("Producer...");

                synchronized (this) {
                    try {
                        this.notifyAll();
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private boolean hasNext() {
            return number < maxNumber;
        }

    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.err.println("Consumer...");

                synchronized (this) {
                    try {
                        this.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        private boolean hasNext() {
            return number > 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        new Thread(producer).start();
        new Thread(consumer).start();
        System.in.read();
    }
}
