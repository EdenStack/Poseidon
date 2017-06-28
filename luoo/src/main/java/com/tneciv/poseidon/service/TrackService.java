package com.tneciv.poseidon.service;

import com.tneciv.poseidon.entity.Track;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by Tneciv on 2017/4/2.
 */
public interface TrackService {
    
    List<Track> queryListByTrackIds(int[] list);

    @Async("proAsync")
    Future<String> getSth(long sleepTime, String msg) throws InterruptedException;
}
