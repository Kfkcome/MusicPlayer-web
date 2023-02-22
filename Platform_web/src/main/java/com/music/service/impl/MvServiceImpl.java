package com.music.service.impl;

import com.music.domain.Mv;
import com.music.domain.Song;
import com.music.mapper.MvMapper;
import com.music.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

@Service
public class MvServiceImpl implements MvService {
    @Autowired
    private MvMapper mvMapper;
    @Override
    public List<Mv> findRandomMv() throws NoSuchAlgorithmException {
        List<Mv> res=new ArrayList<>();
        //防止随机数重复
        Set set=new HashSet();
        // 创建 SecureRandom 对象，并设置加密算法
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        do{
            // 生成 0-9 随机整数
            set.add(random.nextInt(20));
        }while(set.size()<9);
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            // 生成结果
            res.add(mvMapper.selectMvById(it.next()).get(0));
        }
        return res;
    }
}
