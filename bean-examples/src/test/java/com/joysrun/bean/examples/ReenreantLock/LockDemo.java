package com.joysrun.bean.examples.ReenreantLock;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: sin
 * time: 2019-08-20 19:55
 */
public class LockDemo {

    class Bank {

        private volatile int account = 100;

        private ReentrantLock lock = new ReentrantLock();

        public int getAccount() {
            return account;
        }

        /**
         * 用同步方法实现
         *
         * @param money
         */
        public void save(int money) {
            try {
                lock.lock();
                if (account < 300) {
                    account = account + money;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    class NewThread implements Runnable {
        private Bank bank;

        public NewThread(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for (int i = 0; i < 300; i++) {
                // bank.save1(10);
                bank.save(1);
                System.out.println( Thread.currentThread().getName() + "-" + i + "账户余额为：" + bank.getAccount());
            }
        }

    }

    /**
     * 建立线程，调用内部类
     */
    public void useThread() {
        Bank bank = new Bank();
        NewThread new_thread = new NewThread(bank);
        System.out.println("线程1");
        Thread thread1 = new Thread(new_thread);
        thread1.start();
        System.out.println("线程2");
        Thread thread2 = new Thread(new_thread);
        thread2.start();
        System.out.println("线程3");
        Thread thread3 = new Thread(new_thread);
        thread3.start();
    }

    public static void main(String[] args) throws IOException {
        LockDemo st = new LockDemo();
        st.useThread();

        System.in.read();
    }
}
