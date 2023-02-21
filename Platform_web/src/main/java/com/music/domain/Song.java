package com.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    private Integer MusicID;
    private String name;
    private String singer;
    private String type;
    private String address;
    private String mvid;
}
