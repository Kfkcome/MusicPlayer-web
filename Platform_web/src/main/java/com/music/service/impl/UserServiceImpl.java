package com.music.service.impl;

import com.music.domain.*;
import com.music.mapper.UserMapper;
import com.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
        String token=null;
        if (user1 != null) {
            //如果正确 生成token返回
            token = createJWT(UUID.randomUUID().toString(), String.valueOf(user1.getId()), null);
            System.out.println(token);
        }
        return  token;
    }

    @Override
    public UserInfo findUserInfoById(Integer id) {
        return userMapper.selectInfoByID(id);
    }

    @Override
    public boolean updateUserInfoById(Integer id,UserInfo userInfo) {
        int x=userMapper.updateUserInfoById(id,userInfo);
        if(x!=1){
            return false;
        }
        return true;
    }

    @Override
    public List<Playlist> findPlaylist(Integer id) {
        List<Playlist> p=userMapper.selectPlaylist(id);
       return userMapper.selectPlaylist(id);
    }

    @Override
    public int addPlaylist(Integer id,Playlist playlist) {
        List<Playlist> playlists=userMapper.selectPlaylist(id);
        int playlistid=0;
        for(int i=0;i<playlists.size();i++)
        {
            if(playlistid<playlists.get(i).getPlaylistid()){
                playlistid=playlists.get(i).getPlaylistid();
            }
        }
        playlistid+=1;
        playlist.setPlaylistid(playlistid);
        return userMapper.insertPlaylist(id,playlist);
    }

    @Override
    public int addPlaylistSong(PlaylistSong playlistSong) {
        return userMapper.insertSongToPlaylist(playlistSong);
    }

    @Override
    public int deletePlaylistSong(PlaylistSong playlistSong) {
       return  userMapper.deleteSongInPlaylist(playlistSong);
    }
}
