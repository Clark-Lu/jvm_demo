package com.luchang.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/*
 *created by LuChang
 *2018/12/12 15:39
 */
@SpringBootApplication(scanBasePackages = {"com.luchang.demo"})
@EnableAsync
public class StartUp {
    public static void main(String[] args) {
        SpringApplication.run(StartUp.class,args);
    }
}
