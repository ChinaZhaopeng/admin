package com.zp.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SysMenu {

  private int id;
  private int parentId;
  private String icon;
  private String title;
  private String name;
  private String component;
  private String path;
  private String perms;
  private int sort;
  private String type;

}
