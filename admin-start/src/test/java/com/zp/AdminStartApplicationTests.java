package com.zp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class AdminStartApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    void contextLoads() {
    }
    /**
     * 加密
     * */
    @Test
    void encodePassword() {
        System.out.println(passwordEncoder.encode("zhaopeng"));
    }
}
