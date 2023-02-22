package com.music.controller;

import com.music.domain.ResponseResult;
import com.music.domain.Song;
import com.music.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicService musicService;
    @RequestMapping("/Random")
    public ResponseResult<List> FindMusic() throws NoSuchAlgorithmException {//歌曲推动功能，一次推动随机推送10首歌
        return new ResponseResult<>(200,"传输歌曲成功",musicService.RandomFind());
    }
    @PostMapping ("/load")
    public void SongFileLoad(HttpServletResponse response,@RequestBody Song song)throws IOException
    {
        File music=new File(musicService.FindOneMusic(song.getMusicID()).getAddress());
        InputStream ips=new BufferedInputStream(new FileInputStream(music));
        OutputStream ops=new BufferedOutputStream(response.getOutputStream());
        // 一次性取多少个字节
        byte[] bytes = new byte[1024];
        // 用来接收读取的字节数组
        // 读取到的字节数组长度，为-1时表示没有数据
        int length = 0;
        // 循环取数据
        while ((length = ips.read(bytes)) != -1) {
            // 将读取的内容转换成字符串
            ops.write(bytes);
        }
        //将字节数组传输
        ops.flush();
        // 关闭流
        ips.close();
        ops.close();
    }
    @RequestMapping("/type")
    public ResponseResult<List> FindType()
    {
        return new ResponseResult<>(200,"传输歌曲类型成功",musicService.FindAllType());
    }
}
