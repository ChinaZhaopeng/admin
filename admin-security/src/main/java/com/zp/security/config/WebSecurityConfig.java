package com.zp.security.config;

import com.zp.system.mapper.SysMenuMapper;
import com.zp.system.mapper.SysRoleMapper;
import com.zp.system.pojo.SysMenu;
import com.zp.system.pojo.SysRole;
import com.zp.system.pojo.SysUser;
import com.zp.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers("/login").permitAll()
                .anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            SysUser sysUser = sysUserService.selectUserByUsername(username);
            //查询角色
            List<SysRole> sysRoleList = sysRoleMapper.selectRoleListByUser(sysUser);
            String[] sysRoles = sysRoleList.stream().map(SysRole::getName).toArray(String[]::new);
            //查询权限
            List<SysMenu> sysMenuList = sysMenuMapper.selectPermsListByRoleIDList(sysRoleList);
            String[] menuPerms = sysMenuList.stream().map(SysMenu::getPerms).toArray(String[]::new);
            return User.builder().username(username).password(sysUser.getPassword()).roles(sysRoles).authorities(menuPerms).build();
        };
    }
}
