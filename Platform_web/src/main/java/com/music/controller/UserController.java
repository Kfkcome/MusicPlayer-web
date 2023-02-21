package com.music.controller;

import com.music.domain.ResponseResult;
import com.music.domain.User;
import com.music.service.UserService;
import com.music.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.music.utils.JwtUtil.createJWT;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    @CrossOrigin
    public ResponseResult login(@RequestBody User user)
    {
        //校验用户名密码是否正确
        User loginUser = userService.login(user);
        Map<String, Object> map;
        if (loginUser != null) {
            //如果正确 生成token返回
            System.out.println(loginUser.toString());
            map = new HashMap<>();
            String token = createJWT(UUID.randomUUID().toString(), String.valueOf(loginUser.getId()), null);
            System.out.println(token);
            map.put("token", token);
        } else {
            //如果不正确 给出相应的提示
            return new ResponseResult(300, "用户名或密码错误，请重新登录");
        }
        return new ResponseResult(200, "登录成功", map);
    }
}
