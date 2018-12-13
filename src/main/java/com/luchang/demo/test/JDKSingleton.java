package com.luchang.demo.test;

/*
 *created by LuChang
 *2018/12/13 18:16
 */
public class JDKSingleton {
    public static void main(String[] args) {
        System.out.println(JDKSingleton.getSingleton() == JDKSingleton.getSingleton());
    }

    private JDKSingleton(){

    }

    static class Holder{
        private static JDKSingleton jdkSingleton = new JDKSingleton();

        public static JDKSingleton getJdkSingleton() {
            return jdkSingleton;
        }
    }

    public static JDKSingleton getSingleton(){
        return Holder.getJdkSingleton();
    }

}
