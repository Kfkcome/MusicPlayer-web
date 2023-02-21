package com.music.service.impl;

import com.music.mapper.UserMapper;
import com.music.service.TestMysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestMysqlServiceImpl implements TestMysqlService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String FindUser()
    {
        String uid="123";
        String password="123";
        return userMapper.selectByID(uid,password).toString();
    }
}
