package com.music.service;

import com.music.domain.User;
import com.music.domain.UserInfo;

public interface UserService {
    String login(User user);

    UserInfo findUserInfoById(Integer id);
}
