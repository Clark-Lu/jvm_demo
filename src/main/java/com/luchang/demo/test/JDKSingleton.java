package com.luchang.demo.test;

/*
 *created by LuChang
 *2018/12/13 18:16
 */
public class JDKSingleton {
    public static void main(String[] args) {
        System.out.println("调用之前");
        System.out.println(JDKSingleton.getSingleton() == JDKSingleton.getSingleton());
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
