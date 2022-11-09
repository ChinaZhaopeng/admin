package com.zp.system.controller;

import com.zp.common.vo.Result;
import com.zp.system.pojo.SysUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 用户列表查询
     * */
    @GetMapping("list")
    public Result<List<SysUser>> userList(){
        
        return Result.success();
    }
    /**
     * 添加用户
     * */
    @PostMapping("add")
    public Result<List<SysUser>> addUser(){

        return Result.success();
    }
    /**
     * 更新用户
     * */
    @PutMapping("update")
    public Result<List<SysUser>> updateUser(){

        return Result.success();
    }
    /**
     * 删除用户
     * */
    @DeleteMapping ("delete")
    public Result<List<SysUser>> deleteUser(){

        return Result.success();
    }
}
