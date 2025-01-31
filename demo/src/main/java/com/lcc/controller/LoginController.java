package com.lcc.controller;

import com.lcc.pojo.Manager;
import com.lcc.pojo.Result;
import com.lcc.pojo.Staff;
import com.lcc.pojo.User;
import com.lcc.service.ManagerService;
import com.lcc.service.StaffService;
import com.lcc.service.TokenService;
import com.lcc.util.jwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private StaffService staffService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("登录请求: 用户名={}, 密码={}", user.getUsername(), user.getPassword());

        // 首先尝试以 Staff 身份登录
        Staff staff = staffService.login(user);
        if (staff != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", staff.getId());
            claims.put("username", staff.getUsername());
            claims.put("name", staff.getName());
            String jwt = jwtUtils.createjwt(claims);
            return Result.success(jwt,"Staff");
        }

        // 如果 Staff 登录失败，尝试以 Manager 身份登录
        Manager manager = managerService.login(user);
        if (manager != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", manager.getId());
            claims.put("username", manager.getUsername());
            claims.put("name", manager.getName());
            String jwt = jwtUtils.createjwt(claims);
            return Result.success(jwt,"Manager");
        }

        return Result.error("用户名或密码错误");
    }



    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            // 将 Token 加入黑名单或标记为失效
            tokenService.blacklistToken(jwtToken);
            log.info("用户 Token 已加入黑名单: {}", jwtToken);
        } else {
            log.warn("无效的 Token 格式或未提供 Token");
        }
        return Result.success("退出成功");
    }



}
