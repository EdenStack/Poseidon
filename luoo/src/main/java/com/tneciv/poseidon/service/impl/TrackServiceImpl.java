package com.tneciv.poseidon.service.impl;

import com.tneciv.poseidon.dao.TrackExtMapper;
import com.tneciv.poseidon.entity.Track;
import com.tneciv.poseidon.service.TrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by Tneciv on 2017/4/2.
 */
@Slf4j
@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackExtMapper trackExtMapper;

    @Override
    public List<Track> queryListByTrackIds(int[] list) {
        return this.trackExtMapper.queryListByTrackIds(list);
    }

    @Override
    @Async("proAsync")
    public Future<String> getSth(long sleepTime, String msg) throws InterruptedException {
        Thread current = Thread.currentThread();
        long id = current.getId();
        String name = current.getName();
        log.info("Fname : {} , 线程 ID : {} , 名称 : {}", msg, id, name);
        Thread.sleep(sleepTime);
        return new AsyncResult<>(msg);
    }

}
