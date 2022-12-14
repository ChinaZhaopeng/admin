package com.zp.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zp.system.pojo.SysRole;
import com.zp.system.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> selectRoleListByUser(SysUser sysUser);
}
