package com.music.mapper;

import com.music.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
   User selectByID(String uid,String password);
    UserInfo selectInfoByID(Integer id);
    int updateUserInfoById(Integer id,UserInfo userInfo);
    List<Playlist> selectPlaylist(Integer id);
    int insertPlaylist(Integer id,Playlist playlist);
    int insertSongToPlaylist(PlaylistSong playlistSong);
    int deleteSongInPlaylist(PlaylistSong playlistSong);
}
