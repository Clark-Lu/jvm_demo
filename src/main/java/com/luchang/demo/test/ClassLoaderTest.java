package com.luchang.demo.test;

import java.io.IOException;
import java.io.InputStream;

/*
 *created by LuChang
 *2018/12/13 19:41
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")+1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name,bytes,0,bytes.length);
                } catch (IOException e) {
                   return super.loadClass(name);
                }
            }
        };
        Object test = classLoader.loadClass("com.luchang.demo.test.ClassLoaderTest").newInstance();
        Object object = new ClassLoaderTest();
        System.out.println(test instanceof com.luchang.demo.test.ClassLoaderTest);
        System.out.println(object instanceof com.luchang.demo.test.ClassLoaderTest);
    }


}
