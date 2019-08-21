package com.joysrun.bean.examples.thread;

import java.io.IOException;

/**
 * author: sin
 * time: 2019-08-20 18:54
 */
public class ThreadDemo {

    private static int number = 0;

    private static int maxNumber = 10;

    static class Producer implements Runnable {

        @Override
        public void run() {
            for (;;) {
                if (hasNext()) {
                    number++;
                    System.err.println("生产: " + number);
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("仓库满了!!!");
                    try {
                        synchronized (this) {
                            notifyAll();
                            wait();
                        }
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
                if (hasNext()) {
                    number--;
                    System.err.println("消费了一个:" + number);

                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("卖完了!!!");
                    synchronized (this) {
                        notifyAll();
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
