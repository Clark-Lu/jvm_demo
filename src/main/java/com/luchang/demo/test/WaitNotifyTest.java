package com.luchang.demo.test;

/**
 * created by LuChang
 * 2019/4/28 16:28
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait 1");
                synchronized (lock){
                    try {
                        Thread.sleep(1000);
                        System.out.println("wait 1 release lock");
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait 2");
                synchronized (lock){
                    try {
                        Thread.sleep(1000);
                        System.out.println("wait 2 release lock");
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                lock.notifyAll();
            }
        }).start();
    }

}
