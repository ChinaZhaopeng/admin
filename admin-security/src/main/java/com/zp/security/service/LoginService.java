package com.zp.security.service;

import com.zp.system.pojo.User;

public interface LoginService {
    String login(User user);

    int register(User user);
}
