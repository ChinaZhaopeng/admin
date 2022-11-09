package com.zp.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zp.system.mapper.SysUserMapper;
import com.zp.system.pojo.SysUser;
import com.zp.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserByUsername(String username) {
        QueryWrapper<SysUser> sysUserQW = new QueryWrapper<>(new SysUser().setUsername(username));
        return sysUserMapper.selectOne(sysUserQW);
    }

}
