package com.music.mapper;

import com.music.domain.Song;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MusicMapper {
    List<Song> SelectAllByID(Integer id);

    List<Song> SelectAllType();

    List<Song> SelectSongsByType(String type);

    List<Song> SelectALlSingers();

    List<Song> SelectSongsBySinger(String singer);
}
