package com.luchang.demo.test;

/*
 *created by LuChang
 *2018/12/13 16:08
 */
public class TryCatchFinallyTest {

    //调用return后，返回值会存在returnValue中，并且在finally块执行结束后返回此returnValue中的值
    public static void main(String[] args) {
        System.out.println(testString());
        System.out.println(testInt());
        System.out.println(testObject());
    }

    private static String testString(){
        String result = "";
        try {
            result = "try";
            return result;
        }catch (Exception e){
            result = "catch";
            return result;
        }finally {
            result = "finally";
        }
        //return在finally之前调用返回finally执行之前的值，在之后调用返回finally的值，String是不可变类型，
        // finally只是改变了result的引用地址，并未能改变returnValue中的引用地址
//        return result;
    }

    private static int testInt(){
        int result = 0;
        try {
            result = 1/0;
//            return result;
        }catch (Exception e){
            result = 2;
//            return result;
        }finally {
            result = 3;
        }
        return result;
    }

    private static Test testObject(){
        Test test = new Test();
        test.setValue(0);
        try {
            test.setValue(1);
            return test;
        }catch (Exception e){
            test.setValue(2);
            return test;
        }finally {
            test.setValue(3);
        }
        //引用可变类型，无论如何返回finally中的值
//        return test;
    }

    static class Test{
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "value=" + value +
                    '}';
        }
    }
}
