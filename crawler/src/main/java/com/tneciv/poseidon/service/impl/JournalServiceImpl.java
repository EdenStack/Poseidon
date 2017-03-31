package com.tneciv.poseidon.service.impl;

import com.tneciv.poseidon.common.CommonUtil;
import com.tneciv.poseidon.dao.JournalExtMapper;
import com.tneciv.poseidon.dao.TrackExtMapper;
import com.tneciv.poseidon.dto.JournalDto;
import com.tneciv.poseidon.dto.TrackDto;
import com.tneciv.poseidon.entity.Journal;
import com.tneciv.poseidon.entity.JournalExample;
import com.tneciv.poseidon.entity.Track;
import com.tneciv.poseidon.service.JournalService;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tneciv on 2017/3/27.
 */
@Service
@Slf4j
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalExtMapper journalMapper;
    @Autowired
    private TrackExtMapper trackExtMapper;
    @Autowired
    private JournalDto.JournalDtoMapper journalJournalDtoMapper;
    @Autowired
    private TrackDto.TrackDtoMapper trackDtoMapper;

    @Override
    public JournalDto queryByJournalId(Integer id) {
        Journal journal = journalMapper.queryByJournalId(id);
        JournalDto dto = this.parseJournalDto(journal);
        return dto;
    }

    @Override
    public List<Journal> queryByLikeTitles(String title) {
        JournalExample example = new JournalExample();
        JournalExample.Criteria criteria = example.createCriteria();
        criteria.andTitleLike(CommonUtil.spliceLikeSQL(title));
        return journalMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Journal> queryByKeyWord(String keyword) {
        JournalExample example = new JournalExample();
        JournalExample.Criteria criteria = example.createCriteria();
        criteria.andKeyWordsLike(CommonUtil.spliceLikeSQL(keyword));
        return journalMapper.selectByExampleWithBLOBs(example);
    }

    private List<JournalDto> parseJournalDto(List<Journal> journalList) {
        List<JournalDto> dtos = Observable.fromIterable(journalList)
                .map(this::parseJournalDto)
                .toList()
                .blockingGet();
        return dtos;
    }

    private JournalDto parseJournalDto(Journal journal) {
        JournalDto dto = journalJournalDtoMapper.toTarget(journal);
        String tracksArr = dto.getTracksArr();
        int[] list = CommonUtil.convertStringToIntArr(tracksArr);
        List<Track> trackList = this.trackExtMapper.queryListByTrackIds(list);
        List<TrackDto> tracks = this.parseTrackList(trackList);
        //TrackDto track = new TrackDto(22, 22, "name", "artist", "coverimg", "album", "mpeurl", new Date());
        //TrackDto track1 = new TrackDto(88, 33, "name", "artist", "coverimg", "album", "mpeurl", new Date());
        //tracks.add(track);
        //tracks.add(track1);
        dto.setTracksList(tracks);
        return dto;
    }

    private TrackDto parseTrack(Track track) {
        return this.trackDtoMapper.toTarget(track);
    }

    private List<TrackDto> parseTrackList(List<Track> tracks) {
        List<TrackDto> dtos = Observable.fromIterable(tracks)
                .map(this::parseTrack)
                .toList()
                .blockingGet();
        return dtos;
    }

}
