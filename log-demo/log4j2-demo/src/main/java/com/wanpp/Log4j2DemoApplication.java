package com.wanpp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.wanpp.test.mapper")
public class Log4j2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Log4j2DemoApplication.class, args);
    }

}

