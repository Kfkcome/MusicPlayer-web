package com.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private Integer MusicID;//歌曲ID
    private String name;//名字
    private String singer;//歌手
    private String type;//歌曲类型
    private String address;//文件地址
    private String mvid;//mv的id
}
