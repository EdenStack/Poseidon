package com.tneciv.poseidon.dao;

import com.tneciv.poseidon.entity.Journal;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * Created by Tneciv on 2017/3/30.
 */
public interface JournalExtMapper extends JournalMapper {

    @Select("SELECT * FROM journal WHERE journal_id = #{journalId}")
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "title", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "journal_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "key_words", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "vol_cover_img", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "tracks", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "relative_vols", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "vol_date", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "create_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "vol_desc", javaType = String.class, jdbcType = JdbcType.LONGVARCHAR)
    })
    Journal queryByJournalId(Integer journalId);

}
