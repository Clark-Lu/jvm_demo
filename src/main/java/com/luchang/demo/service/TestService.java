package com.luchang.demo.service;

import com.luchang.demo.model.OOMObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 *created by LuChang
 *2018/12/12 15:43
 */
@Service
public class TestService {


    public void testHeapAndGC() throws InterruptedException {
            List<OOMObject> list = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                list.add(new OOMObject());
                Thread.sleep(200);
            }
//            //加上这句，在方法返回之前回收list，不加只能等方法返回之后才能回收
//            list = null;
            System.gc();
            Thread.sleep(20000);
    }




}
