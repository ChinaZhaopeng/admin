package com.zp.system.service;

import com.zp.system.pojo.SysUser;

public interface SysUserService {
    SysUser selectUserByUsername(String username);
}
