package com.zp.security.service.impl;

import com.zp.security.service.LoginService;
import com.zp.system.pojo.SysUser;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String login(SysUser sysUser) {
        return null;
    }

    @Override
    public int register(SysUser sysUser) {
        return 0;
    }
}
