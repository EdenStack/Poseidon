package com.tneciv.poseidon.dao;

import com.tneciv.poseidon.dto.JournalDto;
import com.tneciv.poseidon.entity.Journal;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Tneciv on 2017/3/30.
 */
@Repository
public interface JournalExtMapper extends JournalMapper {

    @Select("SELECT * FROM journal WHERE journal_id = #{journalId}")
    Journal queryByJournalId(Integer journalId);

    @Select("SELECT * FROM journal ORDER BY vol_date DESC")
    List<Journal> queryRecent();

    @Select("SELECT * FROM journal WHERE journal_id = #{journalId}")
    @Results(id = JournalDto.DTO_NAME, value = {
            @Result(column = "id", id = true),
            @Result(column = "title"),
            @Result(column = "journal_id", property = "journalId"),
            @Result(column = "key_words", property = "keyWords"),
            @Result(column = "vol_cover_img", property = "volCoverImg"),
            @Result(column = "tracks", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "relative_vols", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "vol_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "vol_desc", javaType = String.class, jdbcType = JdbcType.LONGVARCHAR),
            @Result(property = "tracksList", column = "tracks", many = @Many(select = "com.tneciv.poseidon.dao.TrackExtMapper.queryListByTrackId"))
    })
    JournalDto queryById(Integer journalId);

    @Select("SELECT * FROM journal WHERE journal_id = #{journalId}")
    @ResultMap(JournalDto.DTO_NAME)
    JournalDto queryByxxxxId(Integer journalId);
}
