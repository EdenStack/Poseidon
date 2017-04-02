package com.tneciv.poseidon.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tneciv.poseidon.common.Constant;
import com.tneciv.poseidon.entity.Journal;
import lombok.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tneciv on 2017/3/30.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"createTime"})
public class JournalDto extends Journal implements Serializable {

    private static final long serialVersionUID = 4893090938458935373L;
    @JsonProperty("tracks")
    private List<TrackDto> tracksList;
    @JsonIgnore
    private String tracksArr;

    @Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = Constant.MODEL_TYPE_SPRING)
    public interface JournalDtoMapper {


        @Mapping(source = "tracks", target = "tracksArr")
        JournalDto toTarget(Journal journal);

    }

}
