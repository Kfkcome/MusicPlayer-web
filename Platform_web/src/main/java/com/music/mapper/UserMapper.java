package com.music.mapper;

import com.music.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    public User selectByID(String uid,String password);
}
