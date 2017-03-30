package com.tneciv.poseidon.service.impl;

import com.tneciv.poseidon.common.CommonUtil;
import com.tneciv.poseidon.dao.JournalExtMapper;
import com.tneciv.poseidon.dto.JournalDto;
import com.tneciv.poseidon.dto.TrackDto;
import com.tneciv.poseidon.entity.Journal;
import com.tneciv.poseidon.entity.JournalExample;
import com.tneciv.poseidon.service.JournalService;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    private JournalDto.DtoMapper dtoMapper;

    @Override
    public JournalDto queryByJournalId(Integer id) {
        Journal journal = journalMapper.queryByJournalId(id);
        JournalDto dtoList = this.parseDto(journal);
        return dtoList;
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

    private List<JournalDto> parseDto(List<Journal> journalList) {
        List<JournalDto> dtos = Observable.fromIterable(journalList)
                .map(this::parseDto)
                .toList()
                .blockingGet();
        return dtos;
    }

    private JournalDto parseDto(Journal journal) {
        JournalDto dto = dtoMapper.toTarget(journal);
        List<TrackDto> tracks = new ArrayList<>();
        TrackDto track = new TrackDto(22, 22, "name", "artist", "coverimg", "album", "mpeurl", new Date());
        TrackDto track1 = new TrackDto(33, 33, "name", "artist", "coverimg", "album", "mpeurl", new Date());
        tracks.add(track);
        tracks.add(track1);
        dto.setTracksList(tracks);
        return dto;
    }

}
