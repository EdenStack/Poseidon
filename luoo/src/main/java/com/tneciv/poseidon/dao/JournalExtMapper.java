package com.tneciv.poseidon.dao;

import com.tneciv.poseidon.entity.Journal;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Tneciv on 2017/3/30.
 */
public interface JournalExtMapper extends JournalMapper {

    @Select("SELECT * FROM journal WHERE journal_id = #{journalId}")
    Journal queryByJournalId(Integer journalId);

    @Select("SELECT * FROM journal ORDER BY vol_date DESC")
    List<Journal> queryRecent();
}
