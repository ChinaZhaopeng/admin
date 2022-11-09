package com.zp.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zp.system.pojo.SysMenu;
import com.zp.system.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> selectPermsListByRoleIDList(List<SysRole> sysRoleIDList);
}
