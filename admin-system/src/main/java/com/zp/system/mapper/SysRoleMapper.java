package com.zp.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zp.system.pojo.SysRole;
import com.zp.system.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    @Select("select * from sys_role where id in (select role_id from sys_user_role where user_id = #{id})")
    List<SysRole> selectRolesByUser(SysUser sysUser);
}
