package com.tneciv.poseidon.service;

import com.tneciv.poseidon.dto.TrackDto;
import com.tneciv.poseidon.entity.Track;

import java.util.List;

/**
 * Created by Tneciv on 2017/4/2.
 */
public interface TrackService {
    TrackDto parseTrack(Track track);

    List<TrackDto> parseTrackList(List<Track> tracks);

    List<Track> queryListByTrackIds(int[] list);
}
