package com.music.service.impl;

import com.music.domain.User;
import com.music.mapper.UserMapper;
import com.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        User user1=userMapper.selectByID(user.getUid(),user.getPassword());
        return user1;
    }
}
