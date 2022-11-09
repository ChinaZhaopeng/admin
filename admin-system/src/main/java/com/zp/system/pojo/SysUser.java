package com.zp.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysUser {

  private int id;
  private String avatar;
  private String name;
  private String username;
  private String password;
  private String phone;
  private String email;
  private Timestamp createTime;
  private String createUser;
  private int deptId;

}
