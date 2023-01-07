package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.constant.SecurityConstants;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.entity.JwtUser;
import cn.dsrank.communitymanagement.service.DsUserService;
import cn.dsrank.communitymanagement.service.impl.AuthService;
import cn.dsrank.communitymanagement.utils.StringUtils;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Resource
    private DsUserService dsUserService;
    @Resource
    private AuthService authService;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody DsUser loginer) {
        // 用户登录认证
        HashMap<String, Object> map = new HashMap<>();
        JwtUser jwtUser = null;
        try {
            jwtUser = authService.authLogin(loginer);
        }catch (BadCredentialsException e){
            map.put("code",100);
            map.put("msg",e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        // 认证成功后，将 token 存入响应头中返回
        HttpHeaders httpHeaders = new HttpHeaders();
        // 添加 token 前缀 "Bearer "
        httpHeaders.set(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + jwtUser.getToken());

        return new ResponseEntity<>(jwtUser.getUser(), httpHeaders, HttpStatus.OK);

    }

    @PostMapping("register")
    public Map<String,Object> register(@RequestBody DsUser register){
        Map<String, Object> map = authService.register(register);
        return map;
    }

}
