package com.zp.security.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zp.system.mapper.SysRoleMapper;
import com.zp.system.mapper.SysUserMapper;
import com.zp.system.pojo.SysRole;
import com.zp.system.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {
    //超级管理员用户信息
    @Value("${spring.security.user.name}")
    private String username;
    @Value("${spring.security.user.password}")
    private String password;
    @Value("${spring.security.user.roles}")
    private String roles;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return (username)->{
            if(this.username.equals(username)){
                return User.builder().username(this.username).password(this.password).roles(this.roles).build();
            }
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>(new SysUser().setUsername(username));
            SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
            //查询角色
            List<SysRole> sysRoleList = sysRoleMapper.selectRolesByUser(sysUser);
            String[] sysRoleKeys = sysRoleList.stream().map(SysRole::getKey).toArray(String[]::new);
            //查询权限

            return User.builder().username(username).password(sysUser.getPassword()).disabled(!sysUser.getIsEnable()).roles(sysRoleKeys).authorities("").build();

        };
    }
}
