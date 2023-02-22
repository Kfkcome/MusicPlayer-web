package com.music.service.impl;

import com.music.domain.Song;
import com.music.mapper.MusicMapper;
import com.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;
    @Override
    public List<Song> RandomFind() throws NoSuchAlgorithmException{

        List<Song> res=new ArrayList<>();
        //防止随机数重复
        Set set=new HashSet();
        // 创建 SecureRandom 对象，并设置加密算法
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        do{
            // 生成 0-9 随机整数
            set.add(random.nextInt(10));
        }while(set.size()<9);
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            // 生成结果
            res.add(musicMapper.SelectAllByID(it.next()).get(0));
        }
        return res;
    }
    @Override
    public Song FindOneMusic(Integer id) {
        return musicMapper.SelectAllByID(id).get(0);
    }

    @Override
    public List<String> FindAllType() {
        List <String> strings=new ArrayList<>();
        List<Song> songs=musicMapper.SelectAllType();
        for(int i=0;i<songs.size();i++)
        {
            if(songs.get(i)!=null) strings.add(songs.get(i).getType());
        }
        return strings;
    }

    @Override
    public List<Song> FindSongsByType(String type) {
        return musicMapper.SelectSongsByType(type);
    }

    @Override
    public List<String> FindAllSingers() {
        List<String> strings=new ArrayList<>();
        List<Song> songs=musicMapper.SelectALlSingers();
        for(int i=0;i<songs.size();i++)
        {
            if(songs.get(i)!=null) strings.add(songs.get(i).getSinger());
        }
        return  strings;
    }

    @Override
    public List<Song> FindSongsBySinger(String singer) {
        return musicMapper.SelectSongsBySinger(singer);
    }

}
