package com.music.service.impl;

import com.music.domain.Playlist;
import com.music.domain.Song;
import com.music.mapper.MusicMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.List;

@SpringBootTest
public class MusicServiceImplTest {
    @Autowired
    MusicServiceImpl musicService;
    @Autowired
    MusicMapper musicMapper;
    @Test
    public void testRandomMusic() throws NoSuchAlgorithmException {
        List<Song> res=musicService.RandomFind();
        for(int i=0;i<9;i++)
        {
            System.out.println(res.get(i).getName());
        }
    }
    @Test
    public void testSongFile() throws FileNotFoundException {
        File file=new File("D:\\java学习\\MusicPlatform\\Platform_web\\src\\main\\resources\\song\\周杰伦-稻香.mp3");
        InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
    }
    @Test
    public  void testSongLoad() throws IOException {
        File music=new File("D:\\java学习\\MusicPlatform\\Platform_web\\src\\main\\resources\\song\\周杰伦-稻香.mp3");
        InputStream ips=new BufferedInputStream(new FileInputStream(music));
        OutputStream ops=new BufferedOutputStream(new FileOutputStream("music.mp4"));
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
    @Test
    public void TestSongInPlaylist()
    {
        System.out.println(musicMapper.SelectSongsInPlaylist(new Playlist(1,"123")));
    }
}
