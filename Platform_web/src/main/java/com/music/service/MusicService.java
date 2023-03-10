package com.music.service;

import com.music.domain.Playlist;
import com.music.domain.PlaylistSong;
import com.music.domain.Song;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface MusicService {
    List<Song> RandomFind() throws NoSuchAlgorithmException;//随机查询歌曲信息
    Song FindOneMusic(Integer id);//根据歌曲id查询歌曲信息

    List<String> FindAllType();

    List<Song> FindSongsByType(String type);

    List<String> FindAllSingers();

    List<Song> FindSongsBySinger(String singer);
    List<PlaylistSong> FindSongsInpPlaylist(Playlist playlist);
}
