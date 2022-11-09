package com.zp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
@MapperScan("com.zp.*.mapper")
public class AdminStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminStartApplication.class, args);
    }

}
