package com.tneciv.poseidon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tneciv.poseidon.common.Constant;
import com.tneciv.poseidon.entity.Track;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.io.Serializable;

/**
 * Created by Tneciv on 2017/3/30.
 */
@Data
@ToString
@NoArgsConstructor
@JsonIgnoreProperties({"id", "name", "createTime"})
public class TrackDto extends Track implements Serializable {

    private static final long serialVersionUID = 5189587397872626808L;

    private String trackName;

    @Mapper(componentModel = Constant.MODEL_TYPE_SPRING)
    public interface TrackDtoMapper {

        @Mapping(source = "name", target = "trackName")
        TrackDto toTarget(Track track);

    }

}
