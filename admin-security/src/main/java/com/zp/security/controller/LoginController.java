package com.zp.security.controller;

import com.zp.common.vo.Result;
import com.zp.security.service.LoginService;
import com.zp.system.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 注册
     * */
    @PostMapping("/register ")
    public Result<String> register(@Validated @RequestBody SysUser sysUser){
        int i = loginService.register(sysUser);
        return Result.success();
    }

    /**
     * 登录
     * */
    @PostMapping("/login")
    public Result<String> login(@Validated @RequestBody SysUser sysUser){
        String token = loginService.login(sysUser);
        return Result.success(token);
    }
}
