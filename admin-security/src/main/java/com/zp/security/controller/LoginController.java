package com.zp.security.controller;

import com.zp.common.vo.Result;
import com.zp.security.service.LoginService;
import com.zp.system.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result<String> login(@Validated @RequestBody User user){
        String token = loginService.login(user);
        return Result.success();
    }
}
