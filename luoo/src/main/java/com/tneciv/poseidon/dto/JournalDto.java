package com.tneciv.poseidon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tneciv.poseidon.entity.Journal;
import com.tneciv.poseidon.entity.Track;
import lombok.*;

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
    private List<Track> tracksList;
    
}
