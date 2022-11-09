package com.zp.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysRole {

  private long id;
  private String name;
  private String title;
  private long sort;
  private long root;
  private long admin;

}
