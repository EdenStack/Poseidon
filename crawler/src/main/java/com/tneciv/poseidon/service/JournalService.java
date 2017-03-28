package com.tneciv.poseidon.service;

import com.tneciv.poseidon.entity.Journal;

import java.util.List;

/**
 * Created by Tneciv on 2017/3/27.
 */
public interface JournalService {
    List<Journal> queryByJournalId(Integer id);

    List<Journal> queryByLikeTitles(String title);

    List<Journal> queryByKeyWord(String keyword);
}
