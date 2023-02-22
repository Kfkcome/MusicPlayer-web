package com.music.service;

import com.music.domain.Song;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface MusicService {
    List<Song> RandomFind() throws NoSuchAlgorithmException;//随机查询歌曲信息
    Song FindOneMusic(Integer id);//根据歌曲id查询歌曲信息
}
