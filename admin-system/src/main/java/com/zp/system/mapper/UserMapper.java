package com.zp.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zp.system.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}