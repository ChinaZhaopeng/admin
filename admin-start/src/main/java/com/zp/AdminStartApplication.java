package com.zp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zp.*.mapper")
public class AdminStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminStartApplication.class, args);
    }

}
