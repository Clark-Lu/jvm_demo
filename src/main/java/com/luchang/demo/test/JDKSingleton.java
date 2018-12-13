package com.luchang.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/*
 *created by LuChang
 *2018/12/13 18:16
 */
public class JDKSingleton {
    public static void main(String[] args) {
        System.out.println("调用之前");
        List<Future<JDKSingleton>> list = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            CompletableFuture<JDKSingleton> future = CompletableFuture.supplyAsync(() -> JDKSingleton.getSingleton());
            list.add(future);
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                System.out.println(JDKSingleton.getSingleton() == list.get(i).get());
            } catch (Exception e) {
                continue;
            }
        }
        System.out.println("调用之后");
    }

    private JDKSingleton(){
        System.out.println("单例初始化");
    }

    static class Holder{
        static {
            System.out.println("内部类初始化");
        }
        private static JDKSingleton jdkSingleton = new JDKSingleton();

        public static JDKSingleton getJdkSingleton() {
            return jdkSingleton;
        }
    }

    public static JDKSingleton getSingleton(){
        return Holder.getJdkSingleton();
    }

}
