package com.music.service;

import com.music.domain.Playlist;
import com.music.domain.User;
import com.music.domain.UserInfo;

import java.util.List;

public interface UserService {
    String login(User user);

    UserInfo findUserInfoById(Integer id);

    boolean updateUserInfoById(Integer id,UserInfo userInfo);
    List<Playlist> findPlaylist(Integer id);
    int addPlaylist(Integer id,Playlist playlist);
}
