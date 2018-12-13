package com.luchang.demo.controller;

import com.luchang.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 *created by LuChang
 *2018/12/12 15:40
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/heapAndGC",method = RequestMethod.GET)
    public String heapAndGC() throws InterruptedException {
        testService.testHeapAndGC();
        return "调用成功";
    }

}
