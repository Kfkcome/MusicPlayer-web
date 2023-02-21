package com.music.controller;

import com.music.domain.ResponseResult;
import com.music.domain.Song;
import com.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class MusicController {
    @Autowired
    private MusicService musicService;
    @RequestMapping("/music")
    public ResponseResult<List> FindMusic()
    {
        return new ResponseResult<>(200,"传输歌曲成功",musicService.RandomFind());
    }

}
