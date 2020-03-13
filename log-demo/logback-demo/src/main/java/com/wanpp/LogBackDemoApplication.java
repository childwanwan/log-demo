package com.wanpp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.wanpp.test.mapper")
public class LogBackDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogBackDemoApplication.class, args);
    }

}

