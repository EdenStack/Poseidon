package com.tneciv.poseidon.dto;

import com.tneciv.poseidon.entity.Track;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tneciv on 2017/3/30.
 */
@Data
@ToString
@NoArgsConstructor
public class TrackDto extends Track implements Serializable {

    private static final long serialVersionUID = 5189587397872626808L;

    public TrackDto(Integer id,
                    Integer trackId,
                    String name,
                    String artist,
                    String coverImg,
                    String album,
                    String mp3Url, Date createTime) {
        super(id, trackId, name, artist, coverImg, album, mp3Url, createTime);
    }
}
