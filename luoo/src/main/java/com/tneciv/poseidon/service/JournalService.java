package com.tneciv.poseidon.service;

import com.tneciv.poseidon.common.PageVo;
import com.tneciv.poseidon.dto.JournalDto;

import java.util.List;

/**
 * Created by Tneciv on 2017/3/27.
 */
public interface JournalService {
    JournalDto queryByJournalId(Integer id);

    List<JournalDto> queryByTitle(String title);

    List<JournalDto> queryByKeyWord(String keyword, int pageNum, int pageSize);

    PageVo<JournalDto> queryByKeyword(String keyword, Integer pageNum, Integer pageSize);

    List<JournalDto> queryRecent();
}
