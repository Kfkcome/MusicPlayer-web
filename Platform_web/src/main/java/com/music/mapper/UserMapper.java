package com.music.mapper;

import com.music.domain.User;
import com.music.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
   User selectByID(String uid,String password);

    UserInfo selectInfoByID(Integer id);

    int updateUserInfoById(Integer id,UserInfo userInfo);
}
