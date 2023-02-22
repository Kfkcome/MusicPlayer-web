package com.music.service.impl;

import com.music.domain.Song;
import com.music.mapper.MusicMapper;
import com.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;
    @Override
    public List<Song> RandomFind() throws NoSuchAlgorithmException{

        List<Song> res=new ArrayList<>();
       // 创建 SecureRandom 对象，并设置加密算法
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        for (int i = 0; i < 10; i++) {
            // 生成 0-9 随机整数
            int number = random.nextInt(10);
            // 打印结果
            res.add(musicMapper.SelectAllByID(number).get(0));
        }
        return res;
    }
    @Override
    public Song FindOneMusic(Integer id) {
        return musicMapper.SelectAllByID(id).get(0);
    }
}
