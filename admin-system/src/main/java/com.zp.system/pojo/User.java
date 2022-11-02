package com.zp.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {

    private long id;
    private String name;
    private String username;
    private String password;
    private String phone;
    private String email;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp createUser;
    private long deptId;

}
