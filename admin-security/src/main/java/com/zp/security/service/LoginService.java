package com.zp.security.service;

import com.zp.system.pojo.SysUser;

public interface LoginService {
    String login(SysUser sysUser);

    int register(SysUser sysUser);
}
