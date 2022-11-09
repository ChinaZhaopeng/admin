package com.zp.security.service.impl;

import com.zp.security.service.LoginService;
import com.zp.security.util.JwtUtil;
import com.zp.system.pojo.SysUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(SysUser sysUser) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(sysUser.getUsername(),sysUser.getPassword());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        return JwtUtil.generateToken(User.builder().username(sysUser.getUsername()).build());
    }

    @Override
    public int register(SysUser sysUser) {
        return 0;
    }
}
