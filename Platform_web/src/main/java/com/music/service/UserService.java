package com.music.service;

import com.music.domain.*;

import java.util.List;

public interface UserService {
    String login(User user);

    UserInfo findUserInfoById(Integer id);

    boolean updateUserInfoById(Integer id, UserInfo userInfo);

    List<Playlist> findPlaylist(Integer id);

    int addPlaylist(Integer id, Playlist playlist);

    int addPlaylistSong(PlaylistSong playlistSong);
}
