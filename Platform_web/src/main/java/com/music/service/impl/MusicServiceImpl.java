package com.music.service.impl;

import com.music.domain.Song;
import com.music.mapper.MusicMapper;
import com.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;
    @Override
    public List<Song> RandomFind() {
        return musicMapper.SelectAllByID(1);
    }
}
