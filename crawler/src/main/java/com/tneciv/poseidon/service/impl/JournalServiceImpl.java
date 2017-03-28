package com.tneciv.poseidon.service.impl;

import com.tneciv.poseidon.common.CommonUtil;
import com.tneciv.poseidon.dao.JournalMapper;
import com.tneciv.poseidon.entity.Journal;
import com.tneciv.poseidon.entity.JournalExample;
import com.tneciv.poseidon.service.JournalService;
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
    private JournalMapper journalMapper;

    @Override
    public List<Journal> queryByJournalId(Integer id) {
        JournalExample example = new JournalExample();
        JournalExample.Criteria criteria = example.createCriteria();
        criteria.andJournalIdEqualTo(id);
        return journalMapper.selectByExampleWithBLOBs(example);
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

}
