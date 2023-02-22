package com.music.service.impl;

import com.music.domain.ResponseResult;
import com.music.domain.User;
import com.music.mapper.UserMapper;
import com.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.music.utils.JwtUtil.createJWT;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(User user) {

        User user1=userMapper.selectByID(user.getUid(),user.getPassword());
        Map<String, Object> map;
        String token=new String();
        if (user1 != null) {
            //如果正确 生成token返回
            System.out.println(user1.toString());
            map = new HashMap<>();
            token = createJWT(UUID.randomUUID().toString(), String.valueOf(user1.getId()), null);
            System.out.println(token);
            map.put("token", token);
        } else {
            //如果不正确 给出相应的提示
            return null;
        }
        return token;
    }
}
