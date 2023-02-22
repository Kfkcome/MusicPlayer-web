package com.music.service.impl;

import com.music.domain.UserInfo;
import com.music.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testUpdate()
    {
        int x=userMapper.updateUserInfoById(1,new UserInfo(2,"inf","inf","inf"));
        System.out.println(x);
    }
}
