package com.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistSong {
    private Integer playlistid;
    private Integer musicID;
    private String musicname;

}
