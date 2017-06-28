package com.tneciv.poseidon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEurekaClient
@MapperScan(basePackages = "com.tneciv.poseidon.dao")
@SpringBootApplication
public class LuooApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuooApplication.class, args);
    }
}
