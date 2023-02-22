package com.music.mapper;

import com.music.domain.Playlist;
import com.music.domain.User;
import com.music.domain.UserInfo;
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
}
