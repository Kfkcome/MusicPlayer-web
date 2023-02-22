package com.music.controller;

import com.music.domain.Mv;
import com.music.domain.ResponseResult;
import com.music.domain.Song;
import com.music.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/mv")
public class MvController {
    @Autowired
    private MvService mvService;
    @RequestMapping("/random")
    public ResponseResult<List> findRandomMv() throws NoSuchAlgorithmException {
        return new ResponseResult<>(200,"传输成功",mvService.findRandomMv());
    }
    @RequestMapping("/select")
    public ResponseResult<Mv> findMvByID(@RequestBody Mv mv)
    {
        return new ResponseResult<>(200,"传输成功",mvService.findMvByID(mv.getMvID()));
    }
    @RequestMapping  ("/load")
    public void SongFileLoad(HttpServletResponse response, @RequestBody Mv mv)throws IOException
    {
        File mvLocal=new File(mvService.findMvByID(mv.getMvID()).getAddress());
        InputStream ips=new BufferedInputStream(new FileInputStream(mvLocal));
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
}
