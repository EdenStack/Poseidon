package com.tneciv.poseidon.dao;

import com.tneciv.poseidon.common.SelectInLanguageDriver;
import com.tneciv.poseidon.entity.Track;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Tneciv on 2017/3/30.
 */
public interface TrackExtMapper extends TrackMapper {

    @Select("SELECT * FROM track WHERE track_id = #{trackId}")
    Track queryByTrackId(Integer trackId);

    @Select("SELECT * FROM track WHERE track_id IN (#{tracksIds})")
    @Lang(SelectInLanguageDriver.class)
    List<Track> queryListByTrackIds(@Param("tracksIds") int[] tracksIds);

}
