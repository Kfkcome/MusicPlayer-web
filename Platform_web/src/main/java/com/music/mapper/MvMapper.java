package com.music.mapper;

import com.music.domain.Mv;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MvMapper {
    List<Mv> selectMvById(Integer id);
}
