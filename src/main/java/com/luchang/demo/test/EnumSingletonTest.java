package com.luchang.demo.test;

/**
 * created by LuChang
 * 2019/8/1 13:32
 */
public class EnumSingletonTest {

    public static void main(String[] args) {
        System.out.println("start main");
        System.out.println(getInstance().getName());
        System.out.println(getInstance().getName());
        System.out.println(getInstance().getName());
        System.out.println(getInstance().getName());
    }

    private String name;

    private EnumSingletonTest(){
        System.out.println("init enumSingleton");
        name = "hello";
    }

    public String getName() {
        return name;
    }

    enum Holder{
        SINGLETON;
        private EnumSingletonTest enumSingletonTest;
        Holder() {
            System.out.println("enum construct");
            enumSingletonTest = new EnumSingletonTest();
        }
    }

    public static EnumSingletonTest getInstance(){
        System.out.println("getInstance()");
        return Holder.SINGLETON.enumSingletonTest;
    }

}
