package com.tneciv.poseidon.service.impl;

import com.tneciv.poseidon.dao.TrackExtMapper;
import com.tneciv.poseidon.dto.TrackDto;
import com.tneciv.poseidon.entity.Track;
import com.tneciv.poseidon.service.TrackService;
import io.reactivex.Observable;
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
    @Autowired
    private TrackDto.TrackDtoMapper trackDtoMapper;

    @Override
    public TrackDto parseTrack(Track track) {
        return this.trackDtoMapper.toTarget(track);
    }

    @Override
    public List<TrackDto> parseTrackList(List<Track> tracks) {
        List<TrackDto> dtos = Observable.fromIterable(tracks)
                .map(this::parseTrack)
                .toList()
                .blockingGet();
        return dtos;
    }

    @Override
    public List<Track> queryListByTrackIds(int[] list) {
        return this.trackExtMapper.queryListByTrackIds(list);
    }

}
