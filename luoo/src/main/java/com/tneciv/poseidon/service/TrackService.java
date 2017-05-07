package com.tneciv.poseidon.service;

import com.tneciv.poseidon.entity.Track;

import java.util.List;

/**
 * Created by Tneciv on 2017/4/2.
 */
public interface TrackService {
    
    List<Track> queryListByTrackIds(int[] list);
    
}
