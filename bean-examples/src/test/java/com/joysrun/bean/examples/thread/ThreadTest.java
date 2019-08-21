package com.joysrun.bean.examples.thread;

/**
 * author: sin
 * time: 2019-08-20 16:10
 */
public class ThreadTest {

    public void createThreadTest() {

    }


    static class OneThread extends Thread {

        @Override
        public void run() {
            System.err.println("run...");
        }
    }
}
