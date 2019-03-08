package com.luchang.demo.test;

/**
 * created by LuChang
 * 2019/3/7 19:31
 */
public class MultiThreadTest {

    static class Test{
        public volatile boolean a3 = true;
    }


    private static  boolean[] a = new boolean[1];

    private static volatile boolean a1 = true;

    private static  boolean a2 = true;

    private static volatile Test[] a3 = new Test[64];

    private static  Test a4 = new Test();


    /**
     * 引用类型内存屏障加在引用上，对这个引用的所有操作强制到主存操作
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        a[0] = true;
        a3[63] = a4;
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(100);
                a[0] = false;
                a1 = false;
                a2 = false;
                a3[63].a3 = false;
                a4.a3 = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread0 = new Thread(() -> {
            while (a[0]) {
            }
            System.out.println("a0 out");
        });
        Thread thread1 = new Thread(() -> {
            while (a1) {
            }
            System.out.println("a1 out");
        });
        Thread thread2 = new Thread(() -> {
            while (a2) {
            }
            System.out.println("a2 out");
        });
        Thread thread3 = new Thread(() -> {
            while (a3[63].a3) {
            }
            System.out.println("a3 out");
        });
        Thread thread4 = new Thread(() -> {
            while (a4.a3) {
            }
            System.out.println("a4 out");
        });
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread.start();
    }
}
