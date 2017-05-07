package com.tneciv.poseidon.service.impl;

import com.tneciv.poseidon.dao.TrackExtMapper;
import com.tneciv.poseidon.entity.Track;
import com.tneciv.poseidon.service.TrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
